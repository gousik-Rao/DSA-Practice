package pack.DSA.Week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DistinctPairsWithDifferenceCount {

	public static void main(String[] args) {
		System.out.println(TotalPairs(new int[] {1, 5, 3}, 2));
	}
	
	static public int TotalPairs(int[] nums, int k) {
        // Code here
        int count = 0;
        
//      For k == 0
        if(k == 0) {
        	Map<Integer, Integer> map = new HashMap<>();
        	for(int num : nums) {
        		map.put(num, map.getOrDefault(num, 0) + 1);
        	}
        	
        	for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        		if(entry.getValue() > 1) count++;
        	}
        	return count;
        }
        
//      For values of k > 0
        Set<Integer> valueSet = new HashSet<>();
        
        for(int num : nums) {
        	valueSet.add(num);
        }
        
        for(int setValue : valueSet){
            if(valueSet.contains(setValue + k)){
                count++;
            }
        }
        
        return count;
    }
}
