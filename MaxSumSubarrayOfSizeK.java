package pack.DSA.Week6;

public class MaxSumSubarrayOfSizeK {

	static public int bruteForce(int[] nums, int k) {
		int n = nums.length;
		int end = k, maxSum = Integer.MIN_VALUE;
		
		for(int idx = 0; idx <= n - k; idx++, end++) {
			int sum = 0;
			for(int jdx = idx; jdx < end; jdx++) {
				sum += nums[jdx];
				
			}
			maxSum = Math.max(maxSum, sum);
		}
		
		return maxSum;
	}
	
	static int optimal(int[] nums, int k) {
		int n = nums.length;
		int maxSum = Integer.MIN_VALUE, sum = 0;
		
		for(int idx = 0; idx < n; idx++) {
			if(idx >= k) {
				sum -= nums[idx - k];
			}
			
			sum += nums[idx];
			
			if(idx >= k - 1)
				maxSum = Math.max(maxSum, sum);
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		System.out.println(
				bruteForce(
						new int[] {100, 200, 300, 400}, 2)
				);
	}
}
