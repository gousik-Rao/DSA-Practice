package pack.DSA.Week2.Sorting.QuickSort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {3, 2, 5, 5, 4, 1};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int[] arr, int low, int high) {
		if(low >= high) {
			return;
		}
		
		int s = low, e = high;
		int m = s + (e - s) / 2;
		int pivot = arr[m];
		
		while(s < e) {
			
//			Also a reason why if its already sorted it will not sort it again         
			while(arr[s] < pivot) {
				s++;
			}
			while(arr[e] > pivot) {
				e--;
			}
			if(s <= e) {
				int temp = arr[s];
				arr[s] = arr[e];
				arr[e] = temp;
				s++;
				e--;
			}
		}
		
//		Now my pivot is at the correct index, please sort the 2 halves
		quickSort(arr, low, e);
		quickSort(arr, s, high);
	}
}
