package pack.DSA.Week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		backtrack(check, n, 0, result, new ArrayList<>());
		
		return result;
	}
	
	private static void backtrack(char[][] queenCheck, int n, int row, List<List<String>> queens, List<String> board) {                                    
		if(row == n) {
			queens.add(new ArrayList<>(board));
			return;
		}
		
		for(int col = 0; col < n; col++) {
			if(isSafe(queenCheck, row, col, n)) {
				
				queenCheck[row][col] = 'Q';
				board.add(new String(queenCheck[row]));
				
				backtrack(queenCheck, n, row + 1, queens, board);
				
				queenCheck[row][col] = '.';
				board.remove(board.size() - 1);
				
			}
		}
	}
	
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
