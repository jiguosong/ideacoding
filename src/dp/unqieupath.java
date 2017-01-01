package dp;

public class unqieupath {
	
	public int uniquePaths_dp_on_model(int m, int n) {
		if (m < 0 && n < 0) return 0;
		if (m == 0 || n == 0) return 1;
		
		int[][] paths = new int[m][n];
		paths[0][0] = 1;
		
		for(int i = 1; i < m; i++) paths[i][0] = 1;
		for(int i = 1; i < n; i++) paths[0][i] = 1;
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				paths[i][j] = paths[i-1][j] + paths[i][j-1];
			}
		}
	
		return paths[m-1][n-1];
		
	}
	
	public int uniquePaths_dp(int m, int n) {
		if (m < 0 && n < 0) return 0;
		if (m == 0 || n == 0) return 1;
		
		int[][] sum = new int[m][n];
		sum[0][0] = 1;
		
		for(int i = 1; i < m; i++) sum[i][0] = 1;
		for(int i = 1; i < n; i++) sum[0][i] = 1;
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				sum[i][j] = sum[i][j-1] + sum[i-1][j];
			}
		}
		
		return sum[m-1][n-1];
	}

	
	public int uniquePaths(int m, int n) {
		if (m < 0 && n < 0) return 0;
		if (m == 0 || n == 0) return 1;
		
		return uniquePaths_helper(m, n, 0, 0);
	}
	
	private int uniquePaths_helper(int row, int col, int x, int y) {
		if (x == row - 1 && y == col - 1) return 1;
		
		if (x < row - 1 && y < col - 1) {
			return uniquePaths_helper(row, col, x+1, y) +  
				    uniquePaths_helper(row, col, x, y+1);
		}
		
		if (x < row - 1) return uniquePaths_helper(row, col, x+1, y);
		if (y < col - 1) return uniquePaths_helper(row, col, x, y+1);
		
		return 0;
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (m < 0 && n < 0) return 0;
		
		return uniquePaths_helper2(obstacleGrid, m, n, 0, 0);
	}
	
	private int uniquePaths_helper2(int[][] matrix, int row, int col, int x, int y) {
		if (x == row - 1 && y == col - 1) return 1;		
		if (x < row - 1 && y < col - 1 && matrix[x][y] == 1) return 0;
		
		if (x < row - 1 && y < col - 1) {
			return uniquePaths_helper2(matrix, row, col, x+1, y) +  
				    uniquePaths_helper2(matrix, row, col, x, y+1);
		}
		
		if (x < row - 1) return uniquePaths_helper2(matrix, row, col, x+1, y);
		if (y < col - 1) return uniquePaths_helper2(matrix, row, col, x, y+1);
		
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		unqieupath test = new unqieupath();
		int m = 3;
		int n = 3;
		int res = test.uniquePaths(m, n);		
		System.out.println(res);
		res = test.uniquePaths_dp(m, n);		
		System.out.println(res);
		res = test.uniquePaths_dp_on_model(m, n);		
		System.out.println(res);
		
		int[][] matrix = {{0,0,0},
						  {0,1,0},
						  {0,0,0}};
		
		res = test.uniquePathsWithObstacles(matrix);
		System.out.println(res);
		
		

	}

}
