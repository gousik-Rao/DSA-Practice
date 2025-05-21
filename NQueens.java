package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class NQueens {

	public static void main(String[] args) {
		System.out.println(solveNQueens(4));
	}
	
	static public List<List<String>> solveNQueens(int n){
		if(n == 1) {
			return List.of(List.of("Q"));
		}
		
		List<List<String>> result = new ArrayList<>();
		char[][] check = new char[n][n];
		for(char[] ch : check) {
			Arrays.fill(ch, '.');
		}
		
		Set<Integer> columns = new HashSet<>();
		Set<Integer> leftDiagonals = new HashSet<>();
		Set<Integer> rightDiagonals = new HashSet<>();
		backtrack(columns, leftDiagonals, rightDiagonals, check, n, 0, result, new ArrayList<>());
		
		return result;
	}
	
	private static void backtrack(Set<Integer> columns, Set<Integer> leftDiag,
			Set<Integer> rightDiag, char[][] queenCheck, int n, int row,
			List<List<String>> queens, List<String> board) {                                    
		if(row == n) {
			queens.add(new ArrayList<>(board));
			return;
		}
		
		for(int col = 0; col < n; col++) {
			
//			Optimized approach using SET for very large numbers, fo rsmalle number upto 1 to 10, Brute - Force approach is more than efficient !!!
			if(!columns.contains(col) && !leftDiag.contains(row - col) && 
					!rightDiag.contains(row + col)) {
				
				columns.add(col);
				leftDiag.add(row - col);
				rightDiag.add(row + col);
				
				queenCheck[row][col] = 'Q';
				board.add(new String(queenCheck[row]));
				
				backtrack(columns, leftDiag, rightDiag, queenCheck, n, row + 1, queens, board);
				
				queenCheck[row][col] = '.';
				columns.remove(col);
				leftDiag.remove(row - col);
				rightDiag.remove(row + col);
				board.remove(board.size() - 1);	
			}
		}
	}
	
	
//	One major consideration is, this solution takes O(N^2) times as it checks each row, and also each column in each row  
	
//	Heart Piece of this problem, in Brute - Force
	static private boolean isSafe(char[][] check, int row, int col, int n) {
		for(int idx = 0; idx < row; idx++) {
			// Current column
			if(check[idx][col] == 'Q')return false; 
			
			// Left diagonal
			if(col - (row - idx) >= 0 && check[idx][col - (row - idx)] == 'Q') return false;
			
			// Right diagonal
			if(col + (row - idx) < n && check[idx][col + (row - idx)] == 'Q') return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
