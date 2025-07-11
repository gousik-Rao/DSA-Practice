package pack.DSA.Week6;

public class ShortestSubarrayWithSumAtleastK {

	static public int shortestSubarray(int[] nums, int k) {
		int shortestLength = -1;
		int n = nums.length;
		
		for(int start = 0; start < n; start++) {
			int sum = 0;
			for(int end = start; end < n; end++) {
				sum += nums[end];
				
				if(sum >= k) {
					shortestLength = sum >= k ? end - start + 1 : -1;
					break;
				}
			}
			System.out.println(sum);
		}
		
		return shortestLength;
	}
	
	public static void main(String[] args) {
		System.out.println(shortestSubarray(
					new int[] {2, -1, 2}, 3
				));
	}
}
