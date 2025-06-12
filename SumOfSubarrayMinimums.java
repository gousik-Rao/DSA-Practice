package pack.DSA.Week6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumOfSubarrayMinimums {

	public static void main(String[] args) {
		sumSubarrayMins(new int[] {3, 1, 2, 4});
	}
	
	static public int sumSubarrayMins(int[] arr) {
		long totalSum = 0;
		int MOD = 1_000_000_007;
        List<List<Integer>> res = new ArrayList<>();
        
        for(int idx = 0; idx < arr.length; idx++){
        	
        	int minValue = Integer.MAX_VALUE;
        	List<Integer> subarray = new LinkedList<Integer>();
        	
            for(int jdx = idx; jdx < arr.length; jdx++){
                minValue = Math.min(minValue, arr[jdx]);
                totalSum += (minValue) % MOD;
                
                subarray.add(arr[jdx]);
                res.add(new LinkedList<>(subarray));
            }            
        }
        
        System.out.println(totalSum);
        System.out.println(res);
        return (int) totalSum;
    }
}
