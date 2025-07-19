package pack.DSA.Week2.Sorting.BubbleSort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 4, 2};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
		
	}
	
	
	static void bubbleSort(int[] arr) {		
		boolean swap;
		for(int idx = 0; idx < arr.length; idx++) {
			swap = false;
			for(int jdx = 1; jdx < arr.length - idx; jdx++) {
				if(arr[jdx] < arr[jdx - 1]) {
					int temp = arr[jdx]; 
					arr[jdx] = arr[jdx - 1]; 
					arr[jdx - 1] = temp;
					swap = true;
				}
			}
//			If we did not swap for a particular value of i,
//			It means the array is sorted, hence stop the program
			if(!swap) {
				System.out.println("Swap true");
				break;
			}
		}
	}
}

































