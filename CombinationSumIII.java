package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {
		System.out.println(combinationSum3(7, 3));
	}
	
	static public List<List<Integer>> combinationSum3(int n, int k){
		return backtrack(n, k, 1, new ArrayList<>(), new ArrayList<>(), 0);
	}
	
	static private List<List<Integer>> backtrack(int n, int k, int start, List<List<Integer>> res, List<Integer> temp, int currentSum){                          
		if(temp.size() == k) {
			if(currentSum == n) {
				res.add(new ArrayList<>(temp));
			}
			return res;
		}
		
		if(currentSum > n)
			return res;
		
		for(int idx = start; idx <= 9; idx++) {
			temp.add(idx);
			backtrack(n, k, idx  + 1, res, temp, currentSum + idx);
			temp.remove(temp.size() - 1); 
		}
		
		return res;
	}
}
