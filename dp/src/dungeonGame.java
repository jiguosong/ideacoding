package dp.src;

public class dungeonGame {
	
	// basically this questio about the initilization condition from the bottom-right
	// and conceptially jump backward
	public int calculateMinimumHP_on_model(int[][] dungeon) {
		if(dungeon == null || dungeon.length == 0) return 0;
		
		int m = dungeon.length; 	
		int n = dungeon[0].length;
		
		int[][] init_blood = new int[m][n];
		init_blood[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);
		
		for(int i = m-2; i >= 0; i--) init_blood[i][n-1] = Math.max(init_blood[i+1][n-1]-dungeon[i][n-1], 1);  // last col
		for(int i = n-2; i >= 0; i--) init_blood[m-1][i] = Math.max(init_blood[m-1][i+1]-dungeon[m-1][i], 1);  // last row
		
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >= 0; j--) {
				int t1 = Math.max(init_blood[i+1][j]-dungeon[i][j], 1);				
				int t2 = Math.max(init_blood[i][j+1]-dungeon[i][j], 1);
				init_blood[i][j] = Math.min(t1, t2);
			}
		}
		
		return init_blood[0][0];
	}
	
	public int calculateMinimumHP(int[][] dungeon) {
		if(dungeon == null || dungeon.length == 0) return 0;
		
		int m = dungeon.length; 	
		int n = dungeon[0].length;
		
		int[][] start_with_blood = new int[m][n];
		start_with_blood[m-1][n-1] = Math.max(1, 1-dungeon[m-1][n-1]);
		
		for(int i = m-2; i >= 0; i--) {
			start_with_blood[i][n-1] = Math.max(1, start_with_blood[i+1][n-1]-dungeon[i][n-1]);
		}
		
		for(int i = n-2; i >= 0; i--) {
			start_with_blood[m-1][i] = Math.max(1, start_with_blood[m-1][i+1]-dungeon[m-1][i]);
		}
		
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >= 0; j--) {
				start_with_blood[i][j] = Math.max(1, Math.min(start_with_blood[i][j+1], start_with_blood[i+1][j])-dungeon[i][j]);
			}
		}
		
		return start_with_blood[0][0];
			
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		dungeonGame test = new dungeonGame();
		
		int[][] dungeon = {{-2,-3,3}, {-5, -10, 1}, {10,30,-5}};
		int ans = test.calculateMinimumHP(dungeon);		
		System.out.println(ans);
		
		ans = test.calculateMinimumHP_on_model(dungeon);		
		System.out.println(ans);

	}

}
