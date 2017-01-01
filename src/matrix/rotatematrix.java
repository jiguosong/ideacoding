package matrix;

public class rotatematrix {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		rotatematrix test = new rotatematrix();
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
		System.out.println();
		
		test.rotate(matrix);
		
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

}
