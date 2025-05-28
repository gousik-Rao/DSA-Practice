package pack.DSA.Week5;

public class ValidPalindromeII {

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
	}
	
	static public boolean validPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		
		while(left < right) {
			if(s.charAt(left) == s.charAt(right)) {
				left++; right--;
			}else {
				if(isPalindrome(left + 1, right, s) ||
						isPalindrome(left, right - 1, s))return true;
								
				return false;
			}
		}
		return true;
	}

	static private boolean isPalindrome(int left, int right, String s) {
		while(left < right) {
			if(s.charAt(right) != s.charAt(left)) return false;
			left++; right--;
		}
		return true;
	}
}
