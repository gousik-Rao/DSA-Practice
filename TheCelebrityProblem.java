package pack.DSA.Week6;

public class TheCelebrityProblem {

	public static void main(String[] args) {
		System.out.println(
				findCelebrityOptimal(new int[][] {
					{0, 1, 1, 0},
					{0, 0, 0, 0},
					{0, 1, 0, 0},
					{1, 1, 0, 0},
				}));
	}
	
//	Brute - Force
	static public int findCelebrity(int[][] mat) {
		int n = mat.length;
		int[] knowMe = new int[n]; // For jdx
		int[] iKnow = new int[n]; // For idx
		
		for(int idx = 0; idx < n; idx++) {
			for(int jdx = 0; jdx < n; jdx++) {
				
				if(jdx != idx && mat[idx][jdx] == 1) {
					knowMe[jdx] += 1;
					iKnow[idx] += 1;
				}
			}
		}
		
		for(int idx = 0; idx < n; idx++) {
			if(knowMe[idx] == n - 1 && iKnow[idx] == 0)
				return idx;
		}
		
		return -1;
	}
	
	// Optimal One
	static public int findCelebrityOptimal(int[][] mat) {
		int n = mat.length;
		int top = 0, down = n - 1;
		
		while(top < down) {
			if(mat[top][down] == 1) top++;
			else if(mat[down][top] == 1) down--;
			else {
				top++; down--;
			}
		}
		
		if(top > down) return -1;
		
		for(int idx = 0; idx < n; idx++) {
			if(idx == down) continue;
			if(mat[down][idx] != 0 && mat[idx][down] != 1) return -1;
		}
		
		return down;
	}
}














