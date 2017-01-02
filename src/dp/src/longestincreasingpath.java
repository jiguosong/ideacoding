package dp.src;

import java.util.Arrays;

public class longestincreasingpath {
	
	public int longestIncreasingPath_DP_DFS(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int res = 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int[][] path = new int[m][n];   // the longest increasing path from this point, inclusive
		int max = 1;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int len = longestIncreasingPath_DP_DFS_helper(matrix, m, n, i, j, path);
				max = Math.max(max, len);
			}
		}
		
		return max;
	}
	
	public int longestIncreasingPath_DP_DFS_helper(int[][] matrix, int m, int n, int i, int j, int[][] path) {
		if(path[i][j] != 0) return path[i][j];
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int max = 1;
		for(int k = 0; k < 4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;			
			int len = longestIncreasingPath_DP_DFS_helper(matrix, m, n, x, y, path) + 1;
			max = Math.max(max, len);			
		}
		
		path[i][j] = max;
		return path[i][j];
	}
	
	// DFS version
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		int res = 0;
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		int[][] path_len = new int[row][col];
		for (int[] k : path_len) Arrays.fill(k, 0);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int len = longestIncreasingPath_helper(matrix, i, j, path_len);
				res = Math.max(res, len);
			}
		}
		
		return res;
	}
	
	
	// in 4 directions
	private int longestIncreasingPath_helper(int[][] matrix, int x, int y, int[][] path_len) {
		if (path_len[x][y] != 0) return path_len[x][y];
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int len;		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length && matrix[nx][ny] > matrix[x][y]) {
				len = longestIncreasingPath_helper(matrix, nx, ny, path_len);
				path_len[x][y] = Math.max(path_len[x][y], len);
			}
		}
		
		return ++path_len[x][y];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		longestincreasingpath test = new longestincreasingpath();
		int[][] matrix = {{9,10,100},
		  		   		  {6,6,8},
		  		          {2,1,1}};
		
		int row = matrix.length;
		int col = matrix[0].length;		
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		int ans = test.longestIncreasingPath(matrix);
		System.out.println(ans);
		
		ans = test.longestIncreasingPath_DP_DFS(matrix);
		System.out.println(ans);
	}

}
