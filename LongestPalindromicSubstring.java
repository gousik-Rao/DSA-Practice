package pack.DSA.Week3;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbd"));
	}
	
	static public String longestPalindrome(String s) {
        if(s.length() == 1) {
        	return s;
        }
        
//        Expanding from the center pattern
        String res = s.substring(0, 1);
        for(int idx = 1; idx < s.length() - 1; idx++) {
        	String odd = expandingFromCenter(s, idx, idx); // For odd - length palindromes
        	String even = expandingFromCenter(s, idx, idx + 1); // For even - length palindromes
        	
        	if(odd.length() > res.length()) res = odd;
        	if(even.length() > res.length()) res = even;
        }
        
        return res;
        
//        Brute Force approach, Checking all sub arrays individually causes
//        O(N^3) for sub-arrays and O(N) for palindrome checks
//        
//        String res = s.substring(0, 1);
//        for(int right = 0; right + 1 <= s.length(); right++) {
//        	int left = 0;
//        	while(left != right) {
//        		String substring = s.substring(left, right + 1);
//        		if(isPalindrome(substring)) {
//        			res = Math.max(res.length(), substring.length()) == substring.length() ? substring : res;             
//        		}
//        		left++;
//        	}
//        }
//        return res;
    }

//	Expanding from center
	static String expandingFromCenter(String s, int left, int right) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--; right++;
		}
		
		return s.substring(left + 1, right);
	}
	
//    static boolean isPalindrome(String s){
//    	int left = 0, right = s.length() - 1;
//    	char[] ch = s.toCharArray();
//    	
//    	while(left < right) {
//    		if(ch[left] != ch[right]) {
//    			return false;
//    		}
//    		left++; right--;
//    	}
//    	
//        return true;
//    }
}
