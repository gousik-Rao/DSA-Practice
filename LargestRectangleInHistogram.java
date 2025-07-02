package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("unused")
public class LargestRectangleInHistogram {
	
	public static void main(String[] args) {
		System.out.println(largestRectangleAreaIn1Pass(new int[] {
			2, 4,	
		}));
	}

	private static int[] findPSE(int[] heights) {
		Deque<Integer> deq = new ArrayDeque<>();
		int[] res = new int[heights.length];
		
		for(int idx = 0; idx < heights.length; idx++) {
			
			while(!deq.isEmpty() && heights[idx] <= heights[deq.peek()]) {
				deq.pop();
			}
			
			if(!deq.isEmpty()) res[idx] = deq.peek();
			else res[idx] = -1;
			
			deq.push(idx); // We subtract index, so we add indices to the stack
		}
		return res;
	}
	
	private static int[] findNSE(int[] heights) {
		Deque<Integer> deq = new ArrayDeque<>();
		int[] res = new int[heights.length];
		
		for(int idx = heights.length - 1; idx >= 0; idx--) {
			
			while(!deq.isEmpty() && heights[idx] < heights[deq.peek()]) {
				deq.pop();
			}
			
			if(!deq.isEmpty()) res[idx] = deq.peek();
			else res[idx] = heights.length;
			
			deq.push(idx); // We subtract index, so we add indices to the stack
		}
		return res;
	}

	private static int largestRectangleAreaUsing2Pass(int[] heights) {
		int[] pse = findPSE(heights);
		int[] nse = findNSE(heights);
		int area = 0;
		
		for(int idx = 0; idx < heights.length; idx++) {
			area = Math.max(area, heights[idx] * (nse[idx] - pse[idx] - 1));
		}
		
		return area;
	}
	
	public  static int largestRectangleAreaIn1Pass(int[] heights) {
		int maxArea = 0;
		Deque<Integer> deq = new ArrayDeque<>();
		
		for(int idx = 0; idx < heights.length; idx++) {
			
			while(!deq.isEmpty() && heights[idx] <= heights[deq.peek()]) {
				int element = deq.pop();
				int nse = idx, pse = deq.isEmpty() ? -1 : deq.peek();
				
				int currentArea = heights[element] * (nse - pse - 1);
				
				maxArea = Math.max(maxArea, currentArea);
			}
			deq.push(idx);
		}
		
		while(!deq.isEmpty()) {
			int element = deq.pop();
			int nse = heights.length;
			int pse = deq.isEmpty() ? -1 : deq.pop();
			
			int currentArea = heights[element] * (nse - pse - 1);
			
			maxArea = Math.max(maxArea, currentArea);
		}
	
		
		return maxArea;
	}
}












