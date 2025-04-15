package pack.Searching.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowels {

	public static void main(String[] args) {
		System.out.println(sortVowels("CodeBattlE"));
	}
	
	static public String sortVowels(String s) {
        // write your code here
        List<Character> list = new ArrayList<>();
        
        for(int idx = 0; idx < s.length(); idx++){
            if(s.charAt(idx) == 'a' || s.charAt(idx) == 'e' || s.charAt(idx) == 'i'
               || s.charAt(idx) == 'o' || s.charAt(idx) == 'u' || s.charAt(idx) == 'A' ||
               s.charAt(idx) == 'O' || s.charAt(idx) == 'U' || s.charAt(idx) == 'E' ||
               s.charAt(idx) == 'I'){
                   list.add(s.charAt(idx));
               }
        }
        
        Collections.sort(list);
        int count = 0;
        char[] ch = s.toCharArray();
        for(int idx = 0; idx < s.length(); idx++){
            if(ch[idx] == 'a' || ch[idx] == 'e' || ch[idx] == 'i'
               || ch[idx] == 'o' || ch[idx] == 'u' || ch[idx] == 'A' ||
               ch[idx] == 'O' || ch[idx] == 'U' || ch[idx] == 'E' ||
               ch[idx] == 'I'){
                   ch[idx] = list.get(count++);
               }
               
        }
        String resString = "";
        for(char c : ch){
            resString = resString + c;
        }
        
        return resString;
    }
}
