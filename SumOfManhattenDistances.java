package pack.DSA.Week2;

import java.util.Arrays;

public class SumOfManhattenDistances {

	public static void main(String[] args) {
		System.out.println(totalDistanceSum(
				new int[] {-1, 1, 3, 2}, new int[] {5, 6, 5, 3}, 4));
	}
	
	static int distanceSum(int[] arr, int n) {
		int sum = 0, res = 0;
		
//		Efficient way
		
		Arrays.sort(arr); // O(N log N) for sorting
		
//		O(N) for the loop as it iterates through all the elements
		for(int idx = 0; idx < n; idx++) {
			res += arr[idx] * idx - sum;
			sum += arr[idx];
		}
		
		return res;
	}
	
	static int totalDistanceSum(int[] x, int[] y, int n) {
		
//		Naive Approach (Brute - Force)
		
//		for(int idx = 0; idx < n; idx++) {
//			int x1 = x[idx], y1 = y[idx];
//			for(int jdx = idx + 1; jdx < n; jdx++) {
//				int x2 = x[jdx], y2 = y[jdx];
//				sum += Math.abs(x1 - x2) + Math.abs(y1 - y2);
//			}
//		}
		
		return distanceSum(x, n) + distanceSum(y, n);
	}
}
