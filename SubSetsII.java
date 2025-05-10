package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(0, nums, result, new ArrayList<>());

        return result;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> subsets) {
        res.add(new ArrayList<>(subsets)); // Add the list before checking the index, as it may go beyond the length

        if(start == nums.length) {
            return;
        }
        
        for(int end = start; end < nums.length; end++){
            if(end > start && nums[end] == nums[end - 1]) continue;

            subsets.add(nums[end]);

            backtrack(end + 1, nums, res, subsets); // Recursion

            subsets.remove(subsets.size() - 1); // Removing the last element for backtracking
        }
    }
}
