package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
	}
	
	static public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		
		if(s.length() < 4 || s.length() > 12)
			return result;
        
        backtrack(0, result, s, new ArrayList<>());
        
        return result;
    }
	
	static private void backtrack(int index, List<String> res, String s, List<String> segments) {                                
		if(segments.size() == 4) {
			if(index == s.length()) {
				res.add(String.join(".", segments));
			}
			return;
		}
		
		for(int idx = 1; idx <= 3; idx++) {
			String str = "";
			int num = -1;
			
			if(index + idx <= s.length()) {
				str = s.substring(index, index + idx);
				
				if(str.length() > 1 && str.startsWith("0")) continue;
				
				num = Integer.valueOf(str);
			}	
			
			if(num >= 0 && num <= 255) {
				segments.add(num + "");
				
				backtrack(index + idx, res, s, segments); // Recursion part
				
				segments.remove(segments.size() - 1); // For backtracking
			}
		}
	}
}
