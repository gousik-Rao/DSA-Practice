package pack.DSA.Week6;

public class ValidWord {

	public boolean isValid(String word) {
		int n = word.length();
		
		// First condition
		if(n < 3) return false;
		
		// Second condition
		String regex = "^[0-9a-zA-Z]+$";
		if(!word.matches(regex)) return false;
		
		// Third condition
		String vowel = "aeiou";
		boolean hasVowel = false;
		
		for(int idx = 0; idx < n; idx++) {
			char ch = Character.toLowerCase(word.charAt(idx));
			if(vowel.indexOf(ch) != -1) {
				hasVowel = true;
				break;
			}
		}
		
//		boolean hasVowel = word.toLowerCase()
//									.chars()
//									.anyMatch(ch -> vowel.contains((char)ch + ""));
		if(!hasVowel) return false;
		
		// Fourth condition
		boolean hasConsonant = word.toLowerCase()
									.chars()
									.anyMatch(
							   ch -> vowel.indexOf(ch) == -1 && Character.isLetter(ch));
		if(!hasConsonant) return false;
		
		return true;
		
	}
}
