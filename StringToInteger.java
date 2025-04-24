package pack.DSA.Week3;

public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(myAtoi("-21474836482"));
	}
	
	static int myAtoi(String s) {
		
		s = s.strip();
		long result = 0;
		int n = s.length();
		if(n == 0) {
			return 0;
		}
		
		boolean isNegative = s.startsWith("-") ? true : false;
		
		for(int idx = isNegative || s.startsWith("+") ? 1 : 0; idx < n; idx++) {
			char character = s.charAt(idx);
			
			if(! Character.isDigit(character))
				break;
			
			int val = character - '0';
			
//			For handling overflow
			if(result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && val > (isNegative ? 8 : 7))){                     
				return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			
			result = (result * 10) + val;
			System.out.println(result);
		}
		
		return isNegative ? (int)(-result) : (int)(result);
	}
}
