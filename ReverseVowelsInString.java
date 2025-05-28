package pack.DSA.Week5;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsInString {

	public String reverseVowels(String str) {
		int s = 0, e = str.length() - 1;
        char[] ch = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'U', 'O'};
        char[] chStr = str.toCharArray();
        Set<Character> vowel = new HashSet<>();
        for(int idx = 0; idx < ch.length; idx++){
            vowel.add(ch[idx]);
        }

        while(s < e){
            if(vowel.contains(chStr[s]) && vowel.contains(chStr[e])){
                swap(s, e, chStr);
                s++; e--;
                continue;
            }
            if(!vowel.contains(chStr[e])){
                e--;
                continue;
            }
            if(!vowel.contains(chStr[s])){
                s++;
                continue;
            }
        }

        StringBuilder res = new StringBuilder();
        for(char c : chStr){
            res.append(c);
        }

        return res.toString();
	}

	private void swap(int s, int e, char[] chStr) {
		char temp = chStr[s];
		chStr[s] = chStr[e];
		chStr[e] = temp;
	}
}
