package pack.DSA.Week4;

public class CountGoodNumbers {

	public static void main(String[] args) {
		System.out.println(countGoodNumbers(50));
	}
	
	static public int countGoodNumbers(long n) {
		long evenCount = (n + 1) / 2; // We will be having n + 1 even and
		long oddCount = n / 2;        // n odd indices
		
		long MOD = (long) Math.pow(10, 9) + 7;
		
		long result = (pow(5, evenCount, MOD) * pow(4, oddCount, MOD)) % MOD;                          
		
		return (int)result;
	}
	
//  Modular exponentiation
	private static long pow(int base, long exponent, long mod) {
		if(exponent == 0)
			return 1;
		
		long half = pow(base, exponent / 2, mod);
		
		if(exponent % 2 == 0)
			return (half * half) % mod;
		
		return (base * half * half) % mod;		
	}

//	Brute force approach
	static public int countGodNumbers(long n) {
        int end = (int) Math.pow(10, n) - 1;
        int start = (int) Math.pow(10, n - 1);
        
        int[] nums = new int[(end - start + 1)];
        int res = 0;
        
        int idx = 0;
        while(start <= end) {
        	nums[idx++] = start++;
        }
        
        for(int jdx = 0; jdx < nums.length; jdx++) {
			if(checkNumber(nums[jdx], nums)) {
				res++;
			}
		}
        
        return res;
    }

	private static boolean checkNumber(long n, int[] nums) {                         
		String num = "" + n;
		int length = num.length();
		int idx = 0;

		for( ;idx < length; idx++) {
			if((num.charAt(idx) - '0') % 2 != 0 && idx % 2 == 0) {
				return false;
			}
			
			else if((idx % 2 != 0) && num.charAt(idx) - '0' != 2 &&
					num.charAt(idx) - '0' != 3 && num.charAt(idx) - '0' != 5
					&& num.charAt(idx) - '0' != 7) {
				return false;
			}
		}
		
		return true;
	}
}
