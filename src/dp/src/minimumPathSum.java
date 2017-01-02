package dp.src;

public class minimumPathSum {
	
	public int minPathSum_dp_on_model(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] sum = new int[m][n];
		
		sum[0][0] = grid[0][0];
		for(int i = 1; i < m; i++) sum[i][0] = sum[i-1][0] + grid[i][0];
		for(int i = 1; i < n; i++) sum[0][i] = sum[0][i-1] + grid[0][i];
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
			}
		}
		
		return sum[m-1][n-1];
	}
	
	
	public int minPathSum_dp(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		
		int m = grid.length;
		int n = grid[0].length;
		int[][] sum = new int[m][n];
		sum[0][0] = grid[0][0];
		
		
		for(int i = 1; i < m; i++) sum[i][0] = sum[i-1][0] + grid[i][0];
		for(int i = 1; i < n; i++) sum[0][i] = sum[0][i-1] + grid[0][i];
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				sum[i][j] = grid[i][j] + Math.min(sum[i][j-1], sum[i-1][j]);
			}
		}
		
		return sum[m-1][n-1];
	}
	
	
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		
		return minPathSum_helper(grid, 0,0);		
	}
	
	private int minPathSum_helper(int[][] grid, int r, int c) {
		if(r == grid.length-1 && c == grid[0].length-1) return grid[r][c];
		
		if(r < grid.length-1 && c < grid[0].length-1) {
			int t1 = grid[r][c]+minPathSum_helper(grid, r+1, c);
			int t2 = grid[r][c]+minPathSum_helper(grid, r, c+1);
			return Math.min(t1, t2);
		}
		
		if(r < grid.length-1) return grid[r][c]+minPathSum_helper(grid, r+1, c);
		if(c < grid[0].length-1) return grid[r][c]+minPathSum_helper(grid, r, c+1);
		
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		minimumPathSum test = new minimumPathSum();
		
		int[][] grid = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		int sum = test.minPathSum(grid);
		
		System.out.println(sum);
		
		sum = test.minPathSum_dp(grid);		
		System.out.println(sum);

		sum = test.minPathSum_dp_on_model(grid);		
		System.out.println(sum);
	}

}
