package matrix;

import java.util.*;

/*You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
*/

// BFS version
public class shortestDistanceBuilding {
	 public int shortestDistance(int[][] grid) {
		 if (grid == null) return 0; 
		 int row = grid.length;
		 int col = grid[0].length;	
		 int res = 0;
		 if (row == 0 || col == 0) return res;
		 
		 int[][] reachBuildings = new int[row][col];   // tracking the number of buildings which can be reached from this point
		 int[][] distance = new int[row][col];        // tracking the sum of distance from each building to this point
		 
		 int numBuild = 0;
		 for (int i = 0; i < row; i++) {
			 for (int j = 0; j < col; j++) {
				 if (grid[i][j] != 1) continue;
				 boolean[][] visited = new boolean[row][col];
				 Deque<Integer> queue = new ArrayDeque<Integer>();
				 shortestDistance_helper(grid, i, j, i, j, 0, reachBuildings, distance, visited, queue);
				 numBuild++;
			 }
		 }		 
		 
		 int minDistance = Integer.MAX_VALUE;
		 int[] anspos = new int [2];
		 for (int i = 0; i < row; i++) {
			 for (int j = 0; j < col; j++) {
				 if (grid[i][j] == 0 && numBuild == reachBuildings[i][j]) {
					 if (distance[i][j] < minDistance) {
						 anspos[0] = i;
						 anspos[1] = j;
					 }
					 minDistance = Math.min(minDistance, distance[i][j]);

				 }
			 }
		 }
 
		 System.out.println(anspos[0]);
		 System.out.println(anspos[1]);
		 res = minDistance;	 
		 return res;
	 }
	 
	 // bfs helper
	 private void shortestDistance_helper(int[][] grid, int curr_x, int curr_y, int x, int y, int disSoFar, 
			 								 int[][] reachBuildings, int[][] distance, boolean[][] visited, Deque<Integer> queue) {
		 int[] dx = {-1, 1, 0, 0};
		 int[] dy = {0, 0, -1, 1};
		 
		 queue.add(curr_x*grid[0].length+curr_y);  // this building
		 distance[curr_x][curr_y] = 0;

		 while(!queue.isEmpty()) {		 
			 int sz = queue.size();
			 disSoFar++;
			 for (int k = 0; k < sz; k++) {
				 int pos = queue.poll();
				 int old_x = pos/grid[0].length;
				 int old_y = pos%grid[0].length;
				 visited[old_x][old_y] = true;
				 
				 for (int m = 0; m < 4; m++) {
					 int new_x = old_x + dx[m];
					 int new_y = old_y + dy[m];	
					 if (new_x < 0 || new_y < 0 ||  new_x >= grid.length || new_y >= grid[0].length) continue;	
					 if (visited[new_x][new_y] == true || grid[new_x][new_y] != 0) continue;

					 visited[new_x][new_y] = true;
					 reachBuildings[new_x][new_y]++;
					 distance[new_x][new_y] += disSoFar;				 
					 queue.add(new_x*grid[0].length+new_y);
				 }
			 }
		 }		 
		 
		 return;
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		shortestDistanceBuilding test = new shortestDistanceBuilding();
		int[][] matrix = {{1,0,2,0,1},
		  		  		{0,0,0,0,0},
		  		  		{0,0, 1,0,0}};
		
		int row = matrix.length;
		int col = matrix[0].length;		
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();		
		int ans = test.shortestDistance(matrix);
		System.out.println(ans);

	}

}
