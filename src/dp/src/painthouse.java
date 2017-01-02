package dp.src;

public class painthouse {	 
	public int minCost_on_model(int[][] costs) {
		if (costs == null) return 0;
		
		int m = costs.length;
		int n = costs[0].length;
		if (m == 0 || n == 0) return 0;
		
		int[][] total_cost = new int[m][n];  // total cost when paint ith house using jth color
		total_cost[0][0] = costs[0][0];
		total_cost[0][1] = costs[0][1];
		total_cost[0][2] = costs[0][2];
		
		for(int i = 1; i < m; i++) {
			for(int j = 0; j < n; j++) {
				total_cost[i][j] = costs[i][j] + Math.min(total_cost[i-1][(j+1)%n], total_cost[i-1][(j+2)%n]);
			}
		}		
	
		return Math.min(Math.min(total_cost[m-1][0], total_cost[m-1][1]), total_cost[m-1][2]);
	}
	
	
	public int minCost(int[][] costs) {
		if (costs == null) return 0;
		
		int row = costs.length;
		int col = costs[0].length;
		if (row == 0 || col == 0) return 0;
		
		for (int i = 1; i < row; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
		}
		
		return Math.min(Math.min(costs[row-1][0], costs[row-1][1]), 
						 costs[row-1][2]);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		painthouse test = new painthouse();		
		
		int[][] costs = {{2, 3, 4}, 
						 {20, 1, 3},
						 {19, 9, 1},
						 {7, 18, 4},
						 {91, 3, 2}};
		int ans = test.minCost(costs);
		System.out.println(ans);
		
		int[][] costs2 = {{2, 3, 4}, 
				 {20, 1, 3},
				 {19, 9, 1},
				 {7, 18, 4},
				 {91, 3, 2}};
		int ans2 = test.minCost_on_model(costs2);
		System.out.println(ans2);		
	}

}
