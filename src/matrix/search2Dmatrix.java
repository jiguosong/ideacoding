package matrix;

import java.util.ArrayList;

public class search2Dmatrix {
	
	// Integers in each row are sorted in ascending from left to right
	// Integers in each column are sorted in ascending from top to bottom
	public boolean searchMatrix_bin(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		int m = matrix.length;
		int n = matrix[0].length;
		
		int row = 0;
		int col = n-1;
		
		while(row < m && col >=0) {
			if(matrix[row][col] == target) return true;
			else if (matrix[row][col] < target) row++;
			else col--;
		}
		
		
		return false;
		
	}
	
	// 1) Integers in each row are sorted from left to right. 2) The first integer of each row is greater than the last integer of the previous row.
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

		int m = matrix.length;
		int n = matrix[0].length;
		
		int left = 0;
		int right = m*n-1;
		
		while(left <= right) {
			int mid = left + (right - left)/2;
			int mid_row = mid/n;
			int mid_col = mid%n;

			if(matrix[mid_row][mid_col] == target) return true;
			else if (matrix[mid_row][mid_col] < target) left = mid+1;
			else right = mid - 1;			
		}
 
		return false;		 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		search2Dmatrix test = new search2Dmatrix();
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}};
		
		int target = 11;
		if(test.searchMatrix(matrix, target)) System.out.println("Found " + target);
		else System.out.println("Can not find " + target);
		
		int[][] matrix2 = {
				{1,   4,  7, 11, 15},
				{2,   5,  8, 12, 19},
				{3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}};
		
		target = 26;
		if(test.searchMatrix_bin(matrix2, target)) System.out.println("Found " + target);
		else System.out.println("Can not find " + target);

	}

}
