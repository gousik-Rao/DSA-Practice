package pack.DSA.Week4;

public class PowerOfTwoBitManipulation {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(19) == 1 ? true : false);
	}
	
	static int isPowerOfTwo(int n) {
		if(n <= 0)
			return -1;
		
//		Using Recursion
		return power(n);
		
//		Using Bit Manipulation
		
//		if(n <= 0) {
//			return false;
//		}
//		return (n & (n - 1)) == 0;
	}
	
	static int power(int n) {
		if(n % 2 != 0) {
			return n;
		}
		
		return power(n / 2);
	}
}
