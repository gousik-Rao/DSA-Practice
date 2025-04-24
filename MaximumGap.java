package pack.DSA.Week3;

import java.util.Arrays;

public class MaximumGap {

	public static void main(String[] args) {
		System.out.println(maximumGap(new int[] {3, 9, 6, 1}));
	}
	
	static public int maximumGap(int[] nums) {
		if(nums.length < 2){
            return 0;
        }

        Arrays.sort(nums);
        int maxDiff = 0, n = nums.length;
        int left = 0, right = 1;
        while(right < n){
            int currentMaxDiff = nums[right] - nums[left];
            maxDiff = Math.max(currentMaxDiff, maxDiff);
            right++;
            left++;
        }

        return maxDiff;
    }
}
