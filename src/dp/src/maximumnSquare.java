package dp.src;

public class maximumnSquare {
	
	/*   select the shortest of longest continous ones in one of the following directions, given X is '1'
            1	 
        1   1    
         1  1    
          1 1
    11111111X   
    */	
	
	
	public int maximalSquare_on_model(char[][] matrix) {
		if (matrix == null) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		if (m == 0 && n == 0) return 0;

		int[][] continous_ones = new int[m][n];   // represents the longest continuous ones until this point, inclusive
		
		for(int i = 0; i < m; i++) continous_ones[i][0] = Character.getNumericValue(matrix[i][0]);
		for(int i = 0; i < n; i++) continous_ones[0][i] = Character.getNumericValue(matrix[0][i]);
		
		int max = 0;
		int x = 0;
		int y = 0;
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(matrix[i][j] == '1') {
					continous_ones[i][j] = Math.min(Math.min(continous_ones[i-1][j], continous_ones[i][j-1]), continous_ones[i-1][j-1]) + 1;
					if (continous_ones[i][j] > max) {
						max = continous_ones[i][j];
						x = i;
						y = j;
					}
				} else {
					continous_ones[i][j] = 0;
				}
			}
		}
		
		return max;
	}
	
	public int maximalSquare(char[][] matrix) {
		if (matrix == null) return 0;
		int row = matrix.length;
		int col = matrix[0].length;
		if (row == 0 && col == 0) return 0;

		int[][] area = new int[row][col];
				
		for (int i = 0; i < row; i++) area[i][0] = Character.getNumericValue(matrix[i][0]);
		for (int j = 0; j < col; j++) area[0][j] = Character.getNumericValue(matrix[0][j]);
		
		int ans= 0;
		int x = 0;
		int y = 0;
		
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == '1') {
					area[i][j] = Math.min(area[i-1][j], Math.min(area[i][j-1], area[i-1][j-1]))+1;
					if (area[i][j] >= ans) {
						ans = area[i][j];
						x = i;
						y = j;
					}
				} else {
					area[i][j] = 0;
				}
			}
		}		
		
		System.out.println(x);
		System.out.println(y);		
		return ans;		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maximumnSquare test = new maximumnSquare();
		int res, row, col;

		char[][] matrix2  = {{'0','1','1','0','1'},
							{'1','1','1','1','0'},
							{'1','1','1','1','0'},
							{'1','1','1','1','0'},
							{'1','1','1','0','1'},
							{'0','0','0','0','0'}};
		row = matrix2.length;
		col = matrix2[0].length;		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix2[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		res = test.maximalSquare(matrix2);
		System.out.println(res);
		
		res = test.maximalSquare_on_model(matrix2);
		System.out.println(res);
	
	}

}