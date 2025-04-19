package pack.DSA.Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] {3, 2, 3}));
	}
	
	static public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 1){
            return Arrays.stream(nums)
            				.boxed()
                    		.collect(Collectors.toList());
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int idx = 0; idx < n; idx++){
            map.put(nums[idx], map.getOrDefault(nums[idx], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        int bound = n/3;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > bound){
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
