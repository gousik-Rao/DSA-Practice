package pack.DSA.Week5;

public class LongestMountainInArray {

	public int longestMountain(int[] arr) {
        // write your code here
        int maxLength = 0;
        
        for(int idx = 1; idx < arr.length - 1; idx++) {
        	if(arr[idx] > arr[idx - 1] && arr[idx] > arr[idx + 1]) {
        		int left = idx - 1, right = idx + 1;
        		
//        		Moving left side
        		while(left > 0 && arr[left] > arr[left - 1]) {
        			left--;
        		}
        		
//        		Moving towards right
        		while(right < arr.length && arr[right] > arr[right + 1]) {
        			right++;
        		}
        		
        		maxLength = Math.max(maxLength, right - left + 1);
        		
        		idx = right;
        	}
        }
        
        return maxLength;
    }
}
