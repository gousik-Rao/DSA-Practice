package pack.DSA.Week2.Sorting.MergeSort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {9, 3, 19, 3, 890, 86, 7, 55, 3};
		arr = mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] mergeSort(int[] arr) {
		// Base case
		if(arr.length <= 1) return arr;
		
		int start = 0, end = arr.length;
		int mid = start + ((end - start) >> 1);
		
		int[] left = mergeSort(Arrays.copyOfRange(arr, start, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, end));
		
		return mergeArrays(left, right);
	}

	private static int[] mergeArrays(int[] left, int[] right) {
		int[] res = new int[left.length + right.length];
		int idx = 0, jdx = 0, kdx = 0;
		
		// Initial merging
		while(idx < left.length && jdx < right.length) {
			if(left[idx] >= right[jdx]) {
				res[kdx] = right[jdx];
				jdx++;
			}else if(left[idx] < right[jdx]) {
				res[kdx] = left[idx];
				idx++;
			}
			kdx++;
		}
		
		// Checking for remaining elements
		while(idx < left.length) {
			res[kdx] = left[idx];
			idx++; kdx++;
		}
		
		while(jdx < right.length) {
			res[kdx] = right[jdx];
			jdx++; kdx++;
		}
		return res;
	}
}






