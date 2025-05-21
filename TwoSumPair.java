package pack.DSA.Week5;

import java.util.HashMap;
import java.util.Map;

public class TwoSumPair {

	boolean twoSum(int arr[], int target) {
        // code here
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int idx = 0; idx < arr.length; idx++){
            int value = target - arr[idx];
            if(map.containsKey(value)){
                return true;
            }else {
                map.put(arr[idx], idx);
            }
        }
        
        return false;
    }
}
