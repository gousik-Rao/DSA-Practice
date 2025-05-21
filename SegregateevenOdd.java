package pack.DSA.Week2;

import java.util.Arrays;

public class SegregateevenOdd {

	public static void main(String[] args) {
		int[] arr = new int[] {2, 1, 4, 5, 3, 6};
		
		segregateEvenOdd(arr);

		System.out.println(Arrays.toString(arr));
	}
	
	static void segregateEvenOdd(int arr[]) {
        // code here
        evenOdd(arr, 0, arr.length);
        
        int count = countEvens(arr);
        
        Arrays.sort(arr, 0, count);
        Arrays.sort(arr, count, arr.length);
        
    }
    
	static void evenOdd(int[] arr, int start, int end){
        if(end - start <= 1){
            return;
        }
        
        int mid = start + ((end - start) >> 1);
        
        evenOdd(arr, start, mid);
        evenOdd(arr, mid, end);
        
        merge(arr, start, mid, end);
    }
    
    static void merge(int[] arr, int s, int m, int e){
        int[] mix = new int[e - s];
        int k = 0;

        // Collecting even numbers
        for(int idx = s; idx < e; idx++){
            if((arr[idx] & 1) != 1) mix[k++] = arr[idx];
        }
        
        // Collecting odd numbers
        for(int idx = s; idx < e; idx++){
            if((arr[idx] & 1) == 1) mix[k++] = arr[idx];
        }
        
        // Adding to the original array
        for(int idx = 0; idx < mix.length; idx++) arr[idx + s] = mix[idx];
        
    }
    
    static int countEvens(int[] arr){
        int count = 0;
        for(int ar : arr){
            if((ar & 1) == 0) count++;
        }
        
        return count;
    }
}









