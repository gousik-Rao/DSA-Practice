package pack.DSA.Week3;

public class MinimumSwaps {

	int minSwap(int[] arr, int k) {
        // Complete the function
        
        int swapCount = 0;
        
        int low = 0, high = arr.length - 1;
        
        while(low <= high){
            if(arr[low] > k && arr[high] <= k){
                swapCount++;
                low++; high--;
            }
            else if(arr[low] <= k){
                low++;
            }else if(arr[high] > k){
                high--;
            }
        }
        
        return swapCount;
    }
}
