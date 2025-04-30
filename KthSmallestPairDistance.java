package pack.Searching.BinarySearch;

import java.util.Arrays;

public class KthSmallestPairDistance {

	public static void main(String[] args) {
		System.out.println(smallestDistancePair(new int[] {1, 2, 2, 4, 5, 6, 7}, 7));                 
	}
	
//	Method for finding the smallest distance pairs
	static public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        // Setting the lower and upper bounds for binary search
        int low = 0, high = nums[nums.length - 1] - nums[0];
        
        while(low < high){                                     
            int mid = low + (high - low) / 2;
            
            int pairs = findingPairs(mid, nums);
            
            if(pairs >= k) {
            	high = mid;
            }else {
            	low = mid + 1;
            }
        }
        return high;
    }
	
//	Counting the total number of pairs using sliding window with diff <= dist
	static int findingPairs(int difference, int[] nums) {
		int res = 0;
		
		for(int left = 0, right = 1; left < nums.length; left++) {
			while(right < nums.length && nums[right] - nums[left] <= difference) {
				right++;
			}
			res += right - left - 1;
			
		}
		return res;
	}
}








