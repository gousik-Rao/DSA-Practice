package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] {2, 3, 6, 7}, 7));
	}
	
	static public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, res, new ArrayList<>());
        
        return res;
    }
	
	static public void backtrack(int index, int[] can, int target,
						List<List<Integer>> res, List<Integer> temp){              
		if(target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		
		if(target < 0) return;
		
		for(int idx = index; idx < can.length; idx++) {
			temp.add(can[idx]);
			backtrack(idx, can, target - can[idx], res, temp);
			temp.remove(temp.size() - 1);
		}
		
	}
}
