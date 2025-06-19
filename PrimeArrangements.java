package pack.DSA.Week6;

import java.util.Arrays;

public class PrimeArrangements {

	public static void main(String[] args) {
		System.out.println(primeArrangements(100));
	}
	
	static public int primeArrangements(int n) {
		int primeCount = countPrimes(n);
		int nonPrimes = n - primeCount;
		int MOD = 1_000_000_007;
		
		int result = (int)(fact(primeCount) * fact(nonPrimes) % MOD);
		
		return result;
	}
	
	static private long fact(int n) {
		long res = 1;
		int MOD = 1_000_000_007;
		
		for(int idx = 2; idx <= n; idx++) {
			res = (res * idx) % MOD;
		}
		
		return res;
	}

	static private int countPrimes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		
		for(int idx = 2; idx <= n; idx++) {
			if(isPrime[idx]) {
				for(int jdx = idx * idx; jdx <= n; jdx += idx) {
					isPrime[jdx] = false;
				}
			}
		}
		
		int countPrime = 0;
		for(int idx = 2; idx < isPrime.length; idx++) {
			if(isPrime[idx]) countPrime += 1;
		}
		return countPrime;
	}
}
