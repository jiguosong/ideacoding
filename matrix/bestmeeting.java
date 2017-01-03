package matrix;

import java.util.*;

/*这道题让我们求最佳的开会地点，该地点需要到每个为1的点的曼哈顿距离之和最小，题目中给了我们提示，
 * 让我们先从一维的情况来分析，那么我们先看一维时有两个点A和B的情况,

______A_____P_______B_______

那么我们可以发现，只要开会为位置P在[A, B]区间内，不管在哪，距离之和都是A和B之间的距离，如果P不在[A, B]之间，
那么距离之和就会大于A和B之间的距离，那么我们现在再加两个点C和D：

______C_____A_____P_______B______D______

我们通过分析可以得出，P点的最佳位置就是在[A, B]区间内，这样和四个点的距离之和为AB距离加上CD距离，在其他任意一点的距离都会大于这个距离，
那么分析出来了上述规律，这题就变得很容易了，我们只要给位置排好序，然后用最后一个坐标减去第一个坐标，即CD距离，倒数第二个坐标减去第二个坐标，
即AB距离，以此类推，直到最中间停止，那么一维的情况分析出来了，二维的情况就是两个一维相加即可
*/
// The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|
// So this problem can be converted to find the median value on x-axis and y-axis.
public class bestmeeting {	
	public int minTotalDistance(int[][] grid) {
		if (grid == null) return 0;
		int row = grid.length;
		int col = grid[0].length;
		
		if (row == 0 || col == 0) return 0;
		
		List<Integer> x_pos = new ArrayList<Integer>();
		List<Integer> y_pos = new ArrayList<Integer>();
		
		for (int i = 0; i < row; i++) { 
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					x_pos.add(i);
					y_pos.add(j);
				}
			}
		}
		
		Collections.sort(x_pos);
		Collections.sort(y_pos);
		
		int ans = 0;
		
		int start = 0;
		int end = x_pos.size() - 1;
		
		while (start < end) {
			ans += x_pos.get(end)-x_pos.get(start) + y_pos.get(end)-y_pos.get(start);
			start++;
			end--;
		}
		
		System.out.println("x_pos median " + x_pos.get(x_pos.size()/2));
		System.out.println("y_pos median " + y_pos.get(y_pos.size()/2));
		
		return ans;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		bestmeeting test=  new bestmeeting();
		
		int[][] matrix = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};

		int row = matrix.length;
		int col = matrix[0].length;		
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		
		int ans = test.minTotalDistance(matrix);		
		System.out.println(ans);
		
	}

}
