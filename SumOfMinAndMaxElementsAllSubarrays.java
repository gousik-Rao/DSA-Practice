package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class SumOfMinAndMaxElementsAllSubarrays {

	static public int minAndMaxSum(int[] nums, int k) {
		int n = nums.length;
		Deque<Integer> maxDeq = new ArrayDeque<>();
		Deque<Integer> minDeq = new ArrayDeque<>();
		
		int max = 0, min = 0;
		
		for(int idx = 0; idx < n; idx++) {
			// For min deque
			if(!minDeq.isEmpty() && minDeq.peekFirst() <= idx - k) {
				minDeq.removeFirst();
			}
			// For max deque
			if(!maxDeq.isEmpty() && maxDeq.peekFirst() <= idx - k) {
				maxDeq.removeFirst();
			}
			
			// Min deque
			while(!minDeq.isEmpty() && nums[idx] <= nums[minDeq.peekLast()])                
				minDeq.removeLast();
			// Max deque
			while(!maxDeq.isEmpty() && nums[idx] >= nums[maxDeq.peekLast()])                
				maxDeq.removeLast();
			
			minDeq.offerLast(idx);
			maxDeq.offerLast(idx);

			// adding the minimum and maximum for current window.
			if(idx >= k - 1) {
				min += nums[minDeq.peekFirst()];
				max += nums[maxDeq.peekFirst()];
			}
							
		}

		System.out.println("Min: " + min);
		System.out.println("Max: " + max);
		
		return max + min;
	}
	
	public static void main(String[] args) {
		int[] largeInput = new int[100000];
		Random sr = new Random(10);
		for(int idx = 0; idx < largeInput.length; idx++)
			largeInput[idx] = sr.nextInt(2000000) - 1000000;
		
		long start = System.currentTimeMillis();
		System.out.println(
				minAndMaxSum(largeInput, 500)
		);
		long end = System.currentTimeMillis();
		
		System.out.println("Execution Time: " + (end - start) + "ms");
	}
}
