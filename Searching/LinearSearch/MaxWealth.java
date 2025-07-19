package pack.DSA.Week2.Searching.LinearSearch;

public class MaxWealth {

	public static void main(String[] args) {
		int[][] accounts = {{2, 3, 1}, {3, 4, 3}};
		
		System.out.println("Richest has a worth of " + richest(accounts));	
	}
	
	static int richest(int[][] arr) {
		int richest = Integer.MIN_VALUE;
		for(int[] num : arr) {
			int sum = 0;
			for(int idx : num) {
				sum += idx;
			}
			if(sum > richest)
				richest = sum;
		}
		return richest;
	}
}
