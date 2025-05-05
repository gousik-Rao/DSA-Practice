package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[] {3, 3, 0, 3}));
	}
	
	static public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		boolean[] array = new boolean[nums.length];
		
		Arrays.fill(array, false);
		Arrays.sort(nums);
		
		backtrack(0, nums, array, result, new ArrayList<>());                                  
        return result;
    }

	static private void backtrack(int index, int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> temp) {                         
		if(temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int idx = 0; idx < nums.length; idx++) {
			if(visited[idx]) continue;
			
			if(idx > 0 && nums[idx] == nums[idx - 1] && !visited[idx - 1]) {
				continue;
			}
			
			temp.add(nums[idx]);
			visited[idx] = true;
			
			backtrack(idx, nums, visited, result, temp);
			
			visited[idx] = false; // When we remove the element then need to update the index to false
			temp.remove(temp.size() - 1);
		}
	}
}
