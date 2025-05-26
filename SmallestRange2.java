package pack.DSA.Week5;

import java.util.Arrays;

public class SmallestRange2 {

	public static void main(String[] args) {
		System.out.println(sumSubarrayMins(new int[] {1, 3, 6}, 3));
	}
	
	 static public int sumSubarrayMins(int[] arr, int k) {
	        // write your code here
		 Arrays.sort(arr);
		 
		 int n = arr.length, result = arr[n - 1] - arr[0];
		 
		 for(int idx = 0; idx < n; idx++) {
			 int right = Math.max(arr[n - 1] - k, arr[idx] + k);
			 int left = Math.min(arr[0] + k, arr[idx + 1] - k);
			 
			 result = Math.min(result, right - left);
		 }
		 
		 return result;
		 
//		 Brute force
		 
//	        int max = Arrays.stream(arr).max().getAsInt();
//	        
//	        for(int idx = 0; idx < arr.length; idx++){
//	            if(arr[idx] + k > max) {
//	                arr[idx] = arr[idx] - k;
//	            }else{
//	                arr[idx] = arr[idx] + k;
//	            }
//	        }
//	        
//	        int maxElem = Arrays.stream(arr).max().getAsInt();
//	        int minElem = Arrays.stream(arr).min().getAsInt();
//	        
//	        return maxElem - minElem;
	 }
}
