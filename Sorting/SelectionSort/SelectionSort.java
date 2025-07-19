package pack.DSA.Week2.Sorting.SelectionSort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {-50, -5, 90, 8, -0, 98, 100, -45};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr) {
		if(arr.length == 1) return;
		
		for(int idx = 0; idx < arr.length; idx++) {
			int lastElementIndex = arr.length - idx - 1;
			int maxElementIndex = getMaxElem(arr, 0, lastElementIndex);
			
			swap(lastElementIndex, maxElementIndex, arr);
		}
	}

	private static void swap(int lastElemIndex, int maxElemIndex, int[] arr) {
		int temp = arr[lastElemIndex];
		arr[lastElemIndex] = arr[maxElemIndex];
		arr[maxElemIndex] = temp;
	}

	private static int getMaxElem(int[] arr, int start, int end) {
		int maxIndex = start;
		for(int idx = start; idx <= end; idx++) {
			if(arr[idx] > arr[maxIndex]) maxIndex = idx;
		}
		return maxIndex;
	}
}
