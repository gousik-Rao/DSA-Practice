package pack.DSA.Week2.Searching.LinearSearch;

public class SearchInString {

	public static void main(String[] args) {
		String input = "Hello world";
		char target = 'W';
		System.out.println(search2(input, target));
	}
	
	static boolean search(String str, char target) {
		if(str.length() == 0)
			return false;
		
		for(int idx = 0; idx < str.length(); idx++) {
			if(target == str.charAt(idx))
				return true;
		}
		return false;
	}
	
	static boolean search2(String str, char target) {
		if(str.length() == 0)
			return false;
		
		for(char ch : str.toCharArray()) {
			if(target == ch)
				return true;
		}
		return false;
	}
}
