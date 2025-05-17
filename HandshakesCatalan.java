package pack.DSA.Week4;

public class HandshakesCatalan {
	
	public static void main(String[] args) {
		System.out.println(countHandshakes(4));
	}
	
	static long countHandshakes(int n) {
//		if((n & 1) == 1) return 0;
		
		return (n & 1) == 1 ? 0 : recurse(n >> 1);
	}
	
	static public long recurse(int n) {
		
		long[] memo = new long[n + 1];
		memo[0] = 1; // Catalan number c(0) = c(1) = 1
		
		for(int person = 1; person <= n; person += 1) {
			for(int next = 0; next < person; next += 1) {
				memo[person] += memo[next] * memo[person - next - 1];
			}
		}
		return memo[n];
	}
}
