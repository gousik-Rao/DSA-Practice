package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(
						maxSlidingWindow(
								new int[] {1, 2, 3, 1, 4, 5, 2, 3, 6}, 3)
						));
	}
	
	static public int[] bruteForce(int[] nums, int k) {
		int n = nums.length;
		List<Integer> res = new ArrayList<>();

		int end = k;
		for(int idx = 0; idx <= n - k; idx++) {
			res.add(maxNum(idx, end++, nums));
		}
		
		return res.stream().mapToInt(num -> num).toArray();
	}
	static int maxNum(int start, int end, int[] nums) {
		int max = Integer.MIN_VALUE;
		
		for(int idx = start; idx < end; idx++) {
			max = Math.max(max, nums[idx]);
		}
		
		return max;
	}
	
	
	static public int[] maxSlidingWindow(int[] nums, int k) {
		
		int n = nums.length;
		Deque<Integer> deq = new ArrayDeque<>();
		int[] res = new int[n - k + 1];
		int resIdx = 0;
		
		for(int idx = 0; idx < n; idx++) {
			
			// Remove from front, if the first element goes out of window
			if(!deq.isEmpty() && deq.peekFirst() <= idx - k)
				deq.removeFirst();
			
			// Remove from back, if the new element is greater than the top element               
			while(!deq.isEmpty() && nums[idx] >= nums[deq.peekLast()])
				deq.removeLast();
			
			deq.add(idx);

			if(idx >= k - 1)
				res[resIdx++] = nums[deq.peekFirst()];
			
		}
		
		return res;
	}
}










