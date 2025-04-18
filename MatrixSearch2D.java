package pack.DSA.Week3;

public class MatrixSearch2D {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]
					{{1, 4, 7, 11, 15},
					{2, 5, 8, 12, 19},
					{3, 6, 9, 16, 22},
					{10, 13, 14, 17, 24},
					{18, 21, 23, 26, 30}}, 20));
	}
	
	static public boolean searchMatrix(int[][] matrix, int target) {
		int rows = 0;
        int cols = matrix[0].length - 1;
                
        if(searchMatrixElement(matrix, target, rows, cols)){
            return true;
        }
        return false;
    }

    static boolean searchMatrixElement(int[][] matrix, int target, int row, int col){    
    	if(row >= matrix.length || col < 0)
    		return false;
    	
    	int currentElem = matrix[row][col];
    	
    	if(currentElem == target){
            return true;
        }else if(target < currentElem) {
        	int newCol = col - 1;
        	return searchMatrixElement(matrix, target, row, newCol);
        }else {
        	int newRow = row + 1;
        	return searchMatrixElement(matrix, target, newRow, col);
        }
        
    }
}
