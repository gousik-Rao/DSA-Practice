package pack.DSA.Week4;

import java.util.Arrays;

public class RatMaze {
	
	public static void main(String[] args) {
		int[][] matrix = {
				{2, 0, 1, 4},
				{0, 1, 0, 3},
				{0, 0, 2, 1},
				{3, 2, 4, 0}
		};
		System.out.println(Arrays.deepToString(ShortestDistance(matrix)));
	}
	
	 static public int[][] ShortestDistance(int[][] matrix) {
	     // Code here
		 int[][] ans = new int[matrix.length][matrix.length];
		 
		 if(! ratMaze(matrix, ans, 0, 0)) {
			 return new int[][] {{-1}};
		 }
		 return ans;
	 }
	    
	 static private boolean ratMaze(int[][] mat, int[][] ans, int idx, int jdx){
		 if(idx == mat.length - 1 && jdx == mat.length - 1) {
			 ans[idx][jdx] = 1;
			 return true;
		 }
		 
		 if(idx >= mat.length || jdx >= mat.length
				 || mat[idx][jdx] == 0)
			 return false;
		 
		 ans[idx][jdx] = 1;
		 
		 for(int step = 1; step <= mat[idx][jdx]; step++) {
			 if(ratMaze(mat, ans, idx, jdx + step) || ratMaze(mat, ans, idx + step, jdx))
				 return true;
			 
//			 else if(ratMaze(mat, ans, idx + step, jdx))
//				 return true;
		 } 
		 
		 ans[idx][jdx] = 0;	
		 return false;
	 }

//	static private boolean withinBoundary(int idx, int jdx, int[][] mat) {
//		if(idx < mat.length - 1 && jdx < mat.length - 1)
//			return true;
//		return false;
//	}
}
