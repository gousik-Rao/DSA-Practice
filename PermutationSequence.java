package pack.DSA.Week3;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		System.out.println(getPermutation(4, 17));
	}	
	
	static public String getPermutation(int n, int k) {
		StringBuilder result = new StringBuilder();
		List<Integer> nums =  new ArrayList<>();
		int[] facts = new int[n];
		
		for(int idx = 1; idx <= n; idx++) {
			nums.add(idx);
			facts[idx - 1] = factorial(idx - 1);
		}
		k--; // For 0 - based indexing
		while(! nums.isEmpty()) {
			int sequence = k / facts[n - 1]; // For finding which sequence we need to go               
			
			result.append(nums.get(sequence));
			nums.remove(sequence);
			
			k %= facts[n - 1]; // For next sequence finding
			n--;
		}
		
		return result.toString();
	}
	
	static int factorial(int num) {
		if(num == 0 || num == 1)
			return 1;
		
		return num * factorial(num - 1);
	}
}
