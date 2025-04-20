package pack.Searching.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSymSubarray {

	public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        if(arr.length == 1){
            return arr[0];
        }
        
        int maxSum = 0;
        for(int idx = 0; idx < k; idx++){
            maxSum += arr[idx];
        }
        int currentSum = maxSum;
        for(int idx = 0; idx <= arr.length - 1 - k; idx++){
            currentSum = currentSum - arr[idx] + arr[idx + k];
            
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
