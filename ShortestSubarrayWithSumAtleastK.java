package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestSubarrayWithSumAtleastK {

	static public int bruteForce(int[] nums, int k) {
		int shortestLength = Integer.MAX_VALUE;
		int n = nums.length;
		
		for(int start = 0; start < n; start++) {
			int sum = 0;
			for(int end = start; end < n; end++) {
				sum += nums[end];
				
				if(sum >= k) {
					int length = end - start + 1;
					shortestLength = sum >= k ? Math.min(shortestLength, length) : -1;            
					break;
				}
			}
			System.out.println(sum);
		}
		
		return shortestLength == Integer.MAX_VALUE ? -1 : shortestLength;
	}
	
	static public int optimalOne(int[] nums, int k) {
		int n = nums.length, res = Integer.MAX_VALUE;
		
		int[] prefix = new int[n + 1];
		prefix[0] = 0;
		Deque<Integer> deq = new ArrayDeque<>();
		deq.addFirst(0);
		
		for(int idx = 1; idx <= n; idx++) {
			prefix[idx] = prefix[idx - 1] + nums[idx - 1]; // Current element + the previous all element's prefix sum
			
			// Similar to -> removing the index from the front, even after removal the condition is set true
			while(!deq.isEmpty() && prefix[idx] - prefix[deq.peekFirst()] >= k) {
				res = Math.min(res, idx - deq.peekFirst());
				deq.removeFirst();
			}
			
			// Maintaining monotonically increasing queue
			while(!deq.isEmpty() && prefix[idx] < prefix[deq.peekLast()])
				deq.removeLast();
			
			deq.offerLast(idx);
		}
		System.out.println(Arrays.toString(prefix));
		return res == Integer.MAX_VALUE ? -1 : res;
	}
	
	public static void main(String[] args) {
		System.out.println(optimalOne(
					new int[] {48, 99, 37, 4, -31, }, 140
				)
		);
	}
}
