package pack.DSA.Week3;

public class ReverseWordsString {

	
	public static void main(String[] args) {
		System.out.println(reverseWords("a good    example"));
	}
	
	static public String reverseWords(String s) {
        String[] strArr = s.strip().split("\\s+"); // Using regex
        
        StringBuilder res = new StringBuilder();
        
        for(int idx = strArr.length - 1; idx >= 0; idx--) {
//        	Using Regex pattern (\\s+)
        	res.append(strArr[idx].strip());
        	if(idx > 0)
        		res.append(" ");
        	
//        	if(strArr[idx] != "") {
//        		res.append(strArr[idx].strip());
//        		if(idx > 0)
//            		res.append(" ");
//        	}
        }
        
        return res.toString();
    }
}
