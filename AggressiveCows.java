package pack.Searching.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {

	public static int aggressiveCows(int[] stalls, int cows) {
        // code here
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] - stalls[0];
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(canWePlaceCowHere(stalls, mid, cows)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return high;
    }
    
    static boolean canWePlaceCowHere(int[] arr, int dist, int cows){
        int countCows = 1, n = arr.length, last = arr[0];
        
        for(int idx = 1; idx < n; idx++){
            if(arr[idx] - last >= dist){
                countCows++;
                last = arr[idx];
                
                if(countCows >= cows) return true; // Returning true if the cow count is equal or grater than the needed cows        

            }
            
        }
        
        return false;
    }
}
