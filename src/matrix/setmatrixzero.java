package matrix;

public class setmatrixzero {
	
	public void setZeroes(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return;
		
		boolean firstrow = false;
		boolean firstcol = false;
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		for (int i = 0; i < col; i++) {
			if (matrix[0][i] == 0) {
					firstrow = true;
					break;
				}
		}		
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
					firstcol = true;
					break;
				}
		}

		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

	
		if (firstrow) { 
			for (int j = 0; j < col; j++) matrix[0][j] = 0;
		}
		
		if (firstcol) { 
			for (int j = 0; j < row; j++) matrix[j][0] = 0;
		}
		
		System.out.println();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
				
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		setmatrixzero test = new setmatrixzero();
		int[][] matrix = {{1,1,1,0},
						  {1,1,1,1},
				          {1,1,0,0},
				          {1,1,1,0}};

		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
		test.setZeroes(matrix);
		
		
	}

}
