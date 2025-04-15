package pack.Searching.BinarySearch;

public class SortedMatrix {
	
	static int[] search(int[][] matrix, int target) {
		int rows = matrix.length, cols = matrix[0].length;
//		Be cautious matrix may be empty.
		
		if(rows == 1) {
			return binarySearch(matrix, 0, 0, cols - 1, target);
		}
		
		int rStart = 0, rEnd = rows - 1, cMid = cols / 2;
//		Run the loop till 2 loops are remaining
		while(rStart < (rEnd - 1)) { // When it becomes true, it will have more than 2 rows
			int mid = rStart + (rEnd - rStart) / 2;
			if(matrix[mid][cMid] == target) {
				return new int[] {mid, cMid};
			}
			if(matrix[mid][cMid] < target) {
				rStart = mid;
			}else {
				rEnd = mid;
			}
		}
		
//		Now we have 2 rows after the loop completed
//		Check whether the target is in the column of 2 rows
		if(matrix[rStart][cMid] == target) {
			return new int[] {rStart, cMid};
		}
		
		if(matrix[rStart + 1][cMid] == target) {
			return new int[] {rStart, cMid};
		}
		
//		Other wise search
//		in 1st half
		if(target <= matrix[rStart][cMid - 1]) {
			return binarySearch(matrix, rStart, 0, cMid - 1, target);
		}
//		or 2nd half
		if(target >= matrix[rStart][cMid + 1] && target < matrix[rStart][cols - 1])    {           
			return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
		}
//		or 3rd half
		if(target <= matrix[rStart + 1][cMid - 1]) {
			return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
		}
//		or 4th half
		else{
			return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
		}
		
	}
	
//	Search in the row provided between the cols provided
	static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {             
		while(cStart <= cEnd) {
			int mid = cStart + (cEnd - cStart) / 2;
			if(matrix[row][mid] == target) {
				return new int[] {row, mid};
			}
			
			if(matrix[row][mid] < target) {
				cStart = mid + 1;
			}else {
				cEnd = mid - 1;
			}
		}
		return new int[] {-1, -1};
	}
}
