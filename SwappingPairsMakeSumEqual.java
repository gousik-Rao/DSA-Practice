package pack.DSA.Week3;

import java.util.HashSet;

public class SwappingPairsMakeSumEqual {

	public static void main(String[] args) {
		System.out.println(findSwapValues(
			new int[] {4, 2, 1, 1, 6, 1, 3}, new int[] {3, 6}));
	}
	
	static private boolean findSwapValues(int[] a, int[] b) {
        // Your code goes here
        int sumOfA = arraySum(a);
        int sumOfB = arraySum(b);
        
        if(sumOfA == sumOfB){
            return true;
        }
        
        int diff = sumOfA - sumOfB;
        if(diff % 2 != 0) {
        	return false;
        }
        int valToCheck = diff / 2;
        
        HashSet<Integer> set = new HashSet<>();
        for(int idx : a) {
        	set.add(idx);
        }
        
        for(int idx = 0; idx < b.length; idx++){
        	
        	if(set.contains(valToCheck + b[idx])) {
        		return true;
        	}
//            for(int jdx = 0; jdx < b.length; jdx++){
//                if(a[idx] == valToCheck + b[jdx]){
//                    return true;
//                }
//            }
        }
        
        return false;
    }
    
    static private int arraySum(int[] arr){
        int arraySum = 0;
        for(int ar : arr){
            arraySum += ar;
        }
        return arraySum;
    }
}
