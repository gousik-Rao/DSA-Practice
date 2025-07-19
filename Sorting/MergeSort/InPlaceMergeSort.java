package pack.DSA.Week2.Sorting.MergeSort;

import java.util.Arrays;

public class InPlaceMergeSort {

	public static void main(String[] args) {
		int[] arr = {5, 5, 4, 3, 2, 1, 1};
		mergeSortInPlace(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));
	}
	
	static void mergeSortInPlace(int[] arr, int start, int end) {
		if(end - start == 1)
			return;
		
		int mid = start + ((end - start) >> 1);
		
		mergeSortInPlace(arr, start, mid);
		mergeSortInPlace(arr, mid, end);

		mergeInPlace(arr, start, mid, end);
	}

	private static void mergeInPlace(int[] arr, int s, int m, int e) {
		int[] mix = new int[e - s];
		
		int i = s, j = m, k = 0;
		
		while(i < m && j < e) {
			if(arr[i] <= arr[j]) {
				mix[k] = arr[i];
				i++;
			}else {
				mix[k] = arr[j];
				j++;
			}
			k++;
		}
		
//		It may be possible that one of the array is not complete
		while(i < m) {
			mix[k] = arr[i];
			i++; k++;
		}
		
		while(j < e) {
			mix[k] = arr[j];
			j++; k++;
		}		
		
		for(int idx = 0; idx < mix.length; idx++) {
		 	arr[s + idx] = mix[idx];
		}
	}
}










