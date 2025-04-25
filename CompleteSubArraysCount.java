package pack.DSA.Week3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CompleteSubArraysCount {

	public static void main(String[] args) {
		System.out.println(countCompleteSubarrays(new int[] {1, 3, 1, 2, 2}));
	}
	
	static public int countCompleteSubarrays(int[] nums) {
//		To get the distinct elements in the array
		Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int k = set.size();
		return countCompleteSubarrays(nums, k) - countCompleteSubarrays(nums, k - 1);                  
	}
	
	static int countCompleteSubarrays(int[] nums, int k){
		
        Map<Integer, Integer> map = new HashMap<>();
        int distinctArrCount = 0;

        for(int left = 0, right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() > k) {
            	map.put(nums[left], map.get(nums[left]) - 1);
            	if(map.get(nums[left]) == 0) {
            		map.remove(nums[left]);
            	}
            	left++;
            	
            }
            distinctArrCount += (right - left) + 1;
        }
        
        return distinctArrCount;
	}

}
