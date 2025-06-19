package pack.DSA.Week6;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		System.out.println(convertToTitle(29));
	}
	
	static public String convertToTitle(int n) {
		// write your code here
		char[] ch = new char[26];
		char c = 'A';
        for(int idx = 0; idx < 26; idx++){
            ch[idx] = c++;
        }
        
        int num = n;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
        	num = num - 1;
        	int rem = num % 26;
        	
        	sb.append(ch[rem]);
        	
        	num /= 26;
        }
        
        return sb.reverse().toString();
	}
}
