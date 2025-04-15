package pack.DSA.Week3;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int idx = 0; idx + 1 < nums.length; idx++){
            int temp = target - nums[idx];
            if(map.containsKey(temp)){
                result[0] = map.get(temp);
                result[1] = idx;
            }else{
                map.put(nums[idx], 1);
            }
        }
        return result;
    }
}
