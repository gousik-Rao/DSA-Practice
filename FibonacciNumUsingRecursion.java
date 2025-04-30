package pack.DSA.Week4;

import java.util.Arrays;

public class FibonacciNumUsingRecursion {

	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		
		System.out.println("Using Tabulation: " + fib(n));
		
		System.out.println("Using Memoization: " + fib(n, dp));
	}
	
//	Memoization (Top - Down DP Approach)
	static int fib(int n, int[] dp) {
		if(n <= 1) return n;
		
		if(dp[n] != -1) return dp[n]; // Check if already computed
		
		// Storing result of sub problem before returning
		return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
	}
	
	static public int fib(int n) {
		
//		Tabulation (Bottom - Up DP approach)
		int one = 0, two = 1;
		for(int idx = 2; idx <= n; idx++) {
			int temp = one + two;
			one = two;
			two = temp;
		}
		
		return two;
		
        // return fiboNum(n);
    }
	
	
//	Naive Brute - Force Approach
    static int fiboNum(int n){
        if(n == 1){
            return 1;
        }
        if(n <= 0)
            return 0;

        return fiboNum(n - 1) + fiboNum(n - 2);
    }
}
