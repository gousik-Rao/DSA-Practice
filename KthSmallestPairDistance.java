package pack.Searching.BinarySearch;

import java.util.Arrays;

public class KthSmallestPairDistance {

	public static void main(String[] args) {
		System.out.println(smallestDistancePair(new int[] {1, 3, 1}, 1));
	}
	
//	Method for finding the smallest distance pairs
	static public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
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
	
//	Counting the total number of pairs using sliding window
	static int findingPairs(int dist, int[] nums) {
		int res = 0;
		
		for(int i = 0; i < nums.length; i++) {
			int j = i + 1;
			while(j < nums.length && nums[j] - nums[i] <= dist) {
				j++;
			}
			res += j - i - 1;
			
		}
		return res;
	}
}
