package pack.DSA.Week5;

public class MaxConsecutiveOnes {

	public int longestOnes(int[] nums, int k) {
		int n = nums.length;
		int res = 0, zerosCount = 0;
		
		for(int s = 0, e = 0; e < n; e++) {
			if(nums[e] == 0) zerosCount++;
			
//			Checking if the number of zeros in the window is greater the given k value,                        
//			If yes then shrink the window.
			if(zerosCount > k) {
				if(nums[s] == 0) zerosCount--;
				s++;
			}
			
			res = Math.max(res, e - s + 1);
		}
		
		return res;
	}
}
