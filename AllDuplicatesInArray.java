package pack.DSA.Week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllDuplicatesInArray {

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3, 2}));
	}
	
//	Brute Force 
	static public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
