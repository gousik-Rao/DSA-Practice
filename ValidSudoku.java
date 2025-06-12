package pack.DSA.Week6;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	@SuppressWarnings("unchecked")
	public boolean solveSudoku(char[][] board) {
		Set<Character>[] rows = new HashSet[9];
		Set<Character>[] cols = new HashSet[9];
		Set<Character>[] boxes = new HashSet[9];
		
		for(int idx = 0; idx < 9; idx++) {
			rows[idx] = new HashSet<>();
			cols[idx] = new HashSet<>();
			boxes[idx] = new HashSet<>();
		}
		
        for(int idx = 0; idx < board.length; idx++) {
        	for(int jdx = 0; jdx < board[idx].length; jdx++) {
        		
        		if(board[idx][jdx] == '.') continue;
        		
        		char ch = board[idx][jdx];
        		
        		if(rows[idx].contains(ch)) return false;
        		if(cols[jdx].contains(ch)) return false;
        		
        		int boxIndex = (idx / 3) * 3 + (jdx / 3);
        		if(boxes[boxIndex].contains(ch))  return false;
        		
        		// If not present in any set then add it to the respective sets
        		rows[idx].add(ch);
        		cols[jdx].add(ch);
        		boxes[boxIndex].add(ch);
        	}
        }
        
        return true;
    }
}
