package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInMatrixFromBottom {

	public static void main(String[] args) {
		System.out.println(maxRectangle(new int[][] {
								{0, 1, 1, 0},
								{1, 1, 1, 1},
								{1, 1, 1, 1}, 
								{1, 1, 0, 0}, }));
	}
	
	static int maxRectangle(int[][] matrix) {
		int[] heights = new int[matrix[0].length];
		int maxArea = 0;
		
		for(int idx = matrix.length - 1; idx >= 0; idx--) {
			for(int jdx = 0; jdx < matrix[0].length; jdx++) {
				if(matrix[idx][jdx] == 1) heights[jdx] += 1;
				else heights[jdx] = 0;
			}
			
			int area = largestRectAngleArea(heights);
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
	}

	private static int[] findPSEE(int[] heights) {
		Deque<Integer> deq = new ArrayDeque<>();
		int[] res = new int[heights.length];
		
		for(int idx = 0; idx < heights.length; idx++) {
			
			while(!deq.isEmpty() && heights[idx] <= heights[deq.peek()]) {
				deq.pop();
			}
			
			res[idx] = (!deq.isEmpty()) ? deq.peek() : -1;
			
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

	private static int largestRectAngleArea(int[] heights) {
		int[] pse = findPSEE(heights);
		int[] nse = findNSE(heights);
		int area = 0;
		
		for(int idx = 0; idx < heights.length; idx++) {
			area = Math.max(area, heights[idx] * (nse[idx] - pse[idx] - 1));
		}
		
		return area;
	}
}













