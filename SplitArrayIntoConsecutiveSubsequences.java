package pack.DSA.Week6;

import java.util.HashMap;

public class SplitArrayIntoConsecutiveSubsequences {

	public boolean split(int[] arr) {
		
//		Stores the remaining element count available
		HashMap<Integer, Integer> availableMap = new HashMap<>();
		
//		Stores the vacancy of the element, if any group requires that element
		HashMap<Integer, Integer> vacancyMap = new HashMap<>();
		
		for(int num : arr) {
			availableMap.put(num, availableMap.getOrDefault(num, 0) + 1);
		}
		
		for(int x  :arr) {
			if(availableMap.get(x) <= 0) continue;
			
//			First we try to extend teh subsequence ending with x - 1
			else if(vacancyMap.getOrDefault(x, 0) > 0) {
				
				// Extend subsequence
				availableMap.put(x, availableMap.getOrDefault(x, 0) - 1);
				vacancyMap.put(x, vacancyMap.getOrDefault(x, 0) - 1);
				
				vacancyMap.put(x + 1, vacancyMap.getOrDefault(x + 1, 0) + 1);
			}
			
			// Else try to start a new subsequence x, x + 1, x + 2, since x is checked in the first condition,
			// we need to check the remaining 2 x + 1 and x + 2 conditions
			else if(availableMap.getOrDefault(x + 1, 0) > 0 && availableMap.getOrDefault(x + 2, 0) > 0) {                              
				availableMap.put(x, availableMap.getOrDefault(x, 0) - 1);
				availableMap.put(x + 1, availableMap.getOrDefault(x + 1, 0) - 1);
				availableMap.put(x + 2, availableMap.getOrDefault(x + 2, 0) - 1);
				
			//	After adding the consecutive 3 elements, we add the next element x + 3 to the vacMap, for further proceedings
				vacancyMap.put(x + 3, vacancyMap.getOrDefault(x + 3, 0) + 1);
			}
			
			else return false;
		}
		
		return true;
	}
}
