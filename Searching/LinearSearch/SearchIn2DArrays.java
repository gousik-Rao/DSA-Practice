package pack.DSA.Week2.Searching.LinearSearch;

import java.util.Arrays;

public class SearchIn2DArrays {

	public static void main(String[] args) {
		int[][] arr = {
				{23, 4, 34},
				{34, 56,},
				{78, 90, 40, 10},
				{56, 99, 100}
		};
		int target = 100;
		int[] ans = search(arr, target);
		System.out.println(Arrays.toString(ans));
		
		System.out.println("Max: " + max(arr));
		System.out.println("Min: " + min(arr));
		
		System.out.println(Integer.MIN_VALUE);
	}
	
	static int[] search(int[][] arr, int target) {
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				if(arr[row][col] == target){
					return new int[] {row, col};
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	static int max(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for(int[] row : arr) {
			for(int element : row) {
				if(element > max){
					max = element;
				}
			}
		}
		return max;
	}
	
	static int min(int[][] arr) {
		int min = Integer.MAX_VALUE;
		for(int[] row : arr) {
			for(int element : row) {
				if(element < min){
					min = element;
				}
			}
		}
		return min;
	}
}













