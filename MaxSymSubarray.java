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
	
	public String sortVowels(String s) {
        // write your code here
        List<Character> list = new ArrayList<>();
        
        for(int idx = 0; idx < s.length(); idx++){
            if(s.charAt(idx) == 'a' || s.charAt(idx) == 'e' || s.charAt(idx) == 'i'
               || s.charAt(idx) == 'o' || s.charAt(idx) == 'u' || s.charAt(idx) == 'A' ||
               s.charAt(idx) == 'O' || s.charAt(idx) == 'U' || s.charAt(idx) == 'E' ||
               s.charAt(idx) == 'I'){
                   list.add(s.charAt(idx));
               }
        }
        
        Collections.sort(list);
        int count = 0;
        for(int idx = 0; idx < s.length(); idx++){
            if(s.charAt(idx) == 'a' || s.charAt(idx) == 'e' || s.charAt(idx) == 'i'
               || s.charAt(idx) == 'o' || s.charAt(idx) == 'u' || s.charAt(idx) == 'A' ||
               s.charAt(idx) == 'O' || s.charAt(idx) == 'U' || s.charAt(idx) == 'E' ||
               s.charAt(idx) == 'I'){
                   s = s.replace(s.charAt(idx), list.get(count++));
               }
        }
        
        return s;
    }
}
