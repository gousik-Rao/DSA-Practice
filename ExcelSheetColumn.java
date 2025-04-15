package pack.Searching.BinarySearch;

public class ExcelSheetColumn {

	public static void main(String[] args) {
		System.out.println(convertToTitle(409379));
	}
	
	static public String convertToTitle(int n) {
		// write your code here
		

		return search(n, new StringBuilder()).toString();
	}
	
	static StringBuilder search(int n, StringBuilder s){
	    if(n <= 0){
		    return s;
		}
		n = n - 1; // for 1 based Index
		
		s.insert(0, (char)('A' +  n % 26));

		n = n / 26;
		
		return search(n, s);
	}
}
