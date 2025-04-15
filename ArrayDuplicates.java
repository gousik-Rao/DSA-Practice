package pack.Searching.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayDuplicates {

	public List<Integer> findDuplicates(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int arrayValue : arr){
            if(map.containsKey(arrayValue)){
                map.put(arrayValue, map.get(arrayValue) + 1);
            }else{
                map.put(arrayValue, 1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> elem : map.entrySet()){
            if(elem.getValue() > 1){
                res.add(elem.getKey());
            }
        }
        return res;
    }
}
