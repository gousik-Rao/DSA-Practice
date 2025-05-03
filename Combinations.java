package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		System.out.println(combine(4, 2));
	}
	
	static public List<List<Integer>> combine(int n, int k){
		return backtrack(n, k, 1, new ArrayList<>(), new ArrayList<>());
		
		
//		if(n == 1) {
//			List<List<Integer>> res = new ArrayList<>();
//			res.add(new ArrayList<>());
//			res.get(0).add(n);
//			return res;
//		}
//		
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		for(int idx = 1; idx < n; idx++) { 
//			
//			int kdx = idx + 1;
//			for(int jdx = 0; jdx <= k - idx; jdx++) {
//				
//				List<Integer> temp = new ArrayList<>();
//				result.add(temp);
//				temp.add(idx);
//				temp.add(kdx);
//				
//				kdx++;
//			}
//		}
//		
//		return result;
	}
	
	static List<List<Integer>> backtrack(int n, int k, int start, List<List<Integer>> res, List<Integer> tempCombo){                             
//		Base Condition
		if(tempCombo.size() == k) {
			res.add(new ArrayList<>(tempCombo));
			return res;
		}
		
		for (int idx = start; idx <= n; idx++) {
			tempCombo.add(start);
			backtrack(n, k, ++start, res, tempCombo); // Recursion
			tempCombo.remove(tempCombo.size() - 1); // Backtrack
		}
		
		return res;
	}
}













