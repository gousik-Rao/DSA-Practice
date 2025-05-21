package pack.DSA.Week2;

public class CountingInversionsUsingMergeSort {

	// Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return countInversions(arr, 0, arr.length);
    }
    
    static private int countInversions(int[] arr, int start, int end){
        if(end - start <= 1){
            return 0;
        }
        
        int mid = start + ((end - start) >> 1);

        int left = countInversions(arr, start, mid);
        int right = countInversions(arr, mid, end);
        
        int result = merge(arr, start, mid, end);
        
        return result + right + left;
    }
    
    static private int merge(int arr[], int s, int m, int e){
        int i = s, j = m, k = 0;
        int[] result = new int[e - s];
        int count = 0;

        while(i < m && j < e){
            if(arr[i] > arr[j]){
        /* -> */count += (m - i); // Most important for achieving O(n Log n)               
                result[k] = arr[j++];
            }else{
            	result[k] = arr[i++];
            }
            k++;
        }
        
        // Here we are swapping the remain elements in ascending order
        while(i < m) result[k++] = arr[i++];
        
        // This is for second array
        while(j < e) result[k] = arr[j];
        
        // Deep copy of array
        for(int idx = 0; idx < result.length; idx++){
            arr[idx + s] = result[idx];
        }
        
        return count;
    }
}
