package pack.DSA.Week3;

public class MaximumNestDepthParantheses {

	public static void main(String[] args) {
		System.out.println(maxDepth("()(())((()()))"));
	}
	
	static public int maxDepth(String s) {
		int maxDepth = 0, currentDepth = 0;
		
		char[] charArray = s.toCharArray();
		for(char chArr : charArray) {
			if(chArr == '(') {
				currentDepth++;
				maxDepth = Math.max(maxDepth, currentDepth);
			}
			else if(chArr == ')') {
				currentDepth--;
			}
		}
		
		return maxDepth;
	}
}
