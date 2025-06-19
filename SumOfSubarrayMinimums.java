package pack.DSA.Week6;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayMinimums {

	public static void main(String[] args) {
		System.out.println(sumSubarrayMins(new int[] {11, 81, 94, 43, 3, }));
	}
	
	static private int[] findNSE(int[] arr){
        int[] nse = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();

        for(int idx = arr.length - 1; idx >= 0; idx--){
            while(!st.isEmpty() && arr[idx] < arr[st.peek()]){
                st.pop();
            }
            nse[idx] = st.isEmpty() ? arr.length : st.peek();
            st.push(idx);
        }
        return nse;
    }

    static private int[] findPSEE(int[] arr){
        int[] psee = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();

        for(int idx = 0; idx < arr.length; idx++){
            while(!st.isEmpty() && arr[idx] <= arr[st.peek()]){
                st.pop();
            }
            psee[idx] = st.isEmpty() ? -1 : st.peek();
            st.push(idx);
        }
        return psee;
    }

    static public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        int MOD = 1_000_000_007;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        for(int idx = 0; idx < n; idx++){
            int previousSmaller = idx - psee[idx];
            int nextSmaller = nse[idx] - idx;
            long contribution = ((long)previousSmaller * nextSmaller) % MOD;
            contribution = (contribution * arr[idx]) % MOD;
            totalSum = (int)((totalSum + contribution) % MOD);                              
        }

        // Brute Force
        // for(int idx = 0; idx < arr.length; idx++){
        //     int minValue = Integer.MAX_VALUE;
        //     for(int jdx = idx; jdx < arr.length; jdx++){
        //         minValue = Math.min(minValue, arr[jdx]);
        //         totalSum = (totalSum + minValue) % MOD;
        //     }
        // }


        return totalSum;
    }
}
