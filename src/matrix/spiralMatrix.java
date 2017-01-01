package matrix;

import java.util.*;

public class spiralMatrix {
	
	public int[][] generateMatrix(int n) {
		if(n == 0) return null;
		
		int[][] matrix = new int[n][n];
		
		int m = n;
		int x = 0;
		int y = 0;
		
		int cnt = 1;
		
		while(m > 0 && n >0) {
			if(m == 1) {
				for(int i = 0; i < n; i++) {
					matrix[x][y++] = cnt++;
				}
				break;
			} else if(n == 1) {
				for(int i = 0; i < m; i++) {
					matrix[x++][y] = cnt++;
				}
				break;
			}
			
			for(int i = 0; i < n-1; i++) {
				matrix[x][y++] = cnt++;
			}
			
			for(int i = 0; i < m-1; i++) {
				matrix[x++][y] = cnt++;
			}

			for(int i = 0; i < n-1; i++) {
				matrix[x][y--] = cnt++;
			}

			for(int i = 0; i < m-1; i++) {
				matrix[x--][y] = cnt++;
			}

			x++;
			y++;
			m -= 2;
			n -= 2;
		}
		
		return matrix;
	}

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return null;
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;
		int n = matrix[0].length;
		
		int x = 0;
		int y = 0;
		
		while(m > 0 && n >0) {
			if(m == 1) {
				for(int i = 0; i < n; i++) {
					res.add(matrix[x][y++]);
				}
				break;
			} else if(n == 1) {
				for(int i = 0; i < m; i++) {
					res.add(matrix[x++][y]);
				}
				break;
			}
			
			for(int i = 0; i < n-1; i++) {
				res.add(matrix[x][y++]);
			}
			
			for(int i = 0; i < m-1; i++) {
				res.add(matrix[x++][y]);
			}

			for(int i = 0; i < n-1; i++) {
				res.add(matrix[x][y--]);
			}

			for(int i = 0; i < m-1; i++) {
				res.add(matrix[x--][y]);
			}

			x++;
			y++;
			m -= 2;
			n -= 2;
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		spiralMatrix test = new spiralMatrix();
		
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}};
		
		ArrayList<Integer> ans = test.spiralOrder(matrix);
		System.out.println(ans);

		System.out.println();
		int[][] ans_matrix = test.generateMatrix(3);
		ans = test.spiralOrder(ans_matrix);
		System.out.println(ans);		
	}

}
