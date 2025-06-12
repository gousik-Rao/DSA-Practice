package pack.DSA.Week5;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers {

	public static void main(String[] args) {
		int k = 2;
		int[] arr = {1, 2, 1, 2, 3,};
		System.out.println(subarrayWithKDifferentIntegers(arr, k) - 
				subarrayWithKDifferentIntegers(arr, k - 1));
	}
	
	static public int subarrayWithKDifferentIntegers(int[] nums, int k) {
		if(nums.length < k) return 0;
		if(nums.length <= 2 && k == 1) return 2;
			
		int s = 0, e = 1, n = nums.length;
		int subarrayCount = 0;
		Map<Integer, Integer> elemMap = new HashMap<>();		
		elemMap.put(nums[s], 1);

		while(s < n && e < n) {			
			elemMap.put(nums[e], elemMap.getOrDefault(nums[e], 0) + 1);
			
//			System.out.println(elemMap.size());
			
			while(s < n && elemMap.size() > k) {
				elemMap.put(nums[s], elemMap.get(nums[s]) - 1);
				
				if(elemMap.get(nums[s]) == 0) elemMap.remove(nums[s]);
				s++;
			}
			
			subarrayCount += e - s + 1;
			e++;
		
		}
		
		return subarrayCount;
	}
}
