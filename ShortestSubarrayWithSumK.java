package pack.DSA.Week6;

public class ShortestSubarrayWithSumK {

	static public int optimal(int target, int[] nums) {
		int n = nums.length;
//		int[] prefix = new int[n];
		
		int start = 0, end = 0;
		int res = Integer.MAX_VALUE, sum = 0;
		
		// Using Two Pointer + Sliding Window, Since the input array does not 
		// Contains negative values.
		while(start < n && end < n) {
			sum += nums[end];
			
			while(sum >= target) {
				res = Math.min(res, end - start + 1);
				sum -= nums[start];
				start++;
			}
			
			end++;
		}
		
		return res == Integer.MAX_VALUE ? 0 : res;
	}
	
	public static void main(String[] args) {
		System.out.println(optimal(
				11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}
			));
	}
}
