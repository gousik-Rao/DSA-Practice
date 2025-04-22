package pack.DSA.Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MajorityElement2 {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {1, 2}));
	}
	
	static public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 1){
            return Arrays.stream(nums)
            				.boxed()
                    		.collect(Collectors.toList());
        }
        
//        Using Moore's Law
        int count1 = 0, count2 = 0;
        int candidate1 = 0, candidate2 = 1;
        
        for(int num : nums) {
        	if(candidate1 == num)
        		count1++;
        	else if(candidate2 == num)
        		count2++;
        	else if(count1 == 0) {
        		candidate1 = num;
        		count1 = 1;  	
        	}else if(count2 == 0) {
        		candidate2 = num;
        		count2 = 1;
        	}else {
        		count1--;
        		count2--;
        	}
        }
        
        count1 = 0; count2 = 0;
        List<Integer> result = new ArrayList<>();
        for(int arr : nums) {
        	if(candidate1 == arr) count1++;
        	else if(candidate2 == arr) count2++;
        }
        
        int n = nums.length;
        if(count1 > n / 3) result.add(candidate1);
    	if(count2 > n / 3) result.add(candidate2);
        
        return result;
        
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int n = nums.length;
//
//        for(int idx = 0; idx < n; idx++){
//            map.put(nums[idx], map.getOrDefault(nums[idx], 0) + 1);
//        }
//
//        List<Integer> result = new ArrayList<>();
//
//        int bound = n/3;
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if(entry.getValue() > bound){
//                result.add(entry.getKey());
//            }
//        }
//
//        return result;
    }
}
