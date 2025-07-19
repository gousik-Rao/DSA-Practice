package pack.DSA.Week2.Sorting.InsertionSort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 1, 2, -90, 9, 30, 100, -45, -55, -3};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void insertionSort(int[] arr) {
		if(arr.length == 1) return;
		
		for(int idx = 0; idx < arr.length - 1; idx++) {
			for(int jdx = idx + 1; jdx > 0; jdx--) {
				if(arr[jdx - 1] > arr[jdx]) {
					swap(arr, jdx, jdx - 1);
				}else break;
			}
		}
	}

	private static void swap(int[] arr, int jdx, int idx) {
		int temp = arr[jdx];
		arr[jdx] = arr[idx];
		arr[idx] = temp;
	}
}
