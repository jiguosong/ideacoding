package dp.src;

public class longestcommonSubsequence {
	
	public int getLongestCommonSubsequence_on_model(String a, String b){
		if(a == null || b == null) return 0;
		int m = a.length();
		int n = b.length();
		if(m == 0 || n == 0) return 0;

		int[][] lcs = new int[m+1][n+1];
		
		lcs[0][0] = 0;  // init
		
		for(int i = 1; i <= m; i++) {
			char c1 = a.charAt(i-1);
			for(int j = 1; j <= n; j++) {
				char c2 = b.charAt(j-1);
				if(c1 == c2) lcs[i][j] = lcs[i-1][j-1] + 1;
				else lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
			}
		}
		
		return lcs[m][n];
	}
	
	public int getLongestCommonSubsequence(String a, String b){
		if(a == null || b == null) return 0;
		int m = a.length();
		int n = b.length();
		if(m == 0 || n == 0) return 0;
		
		int[][] dp = new int[m+1][n+1];

		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == 0 || j == 0) dp[i][j] = 0 ;
				else if(a.charAt(i-1) != b.charAt(j-1)) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				else dp[i][j] = dp[i-1][j-1]+1;
			}
		}
		
		return dp[m][n];		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		longestcommonSubsequence test = new longestcommonSubsequence();
		String a = "ABCDGH";
		String b = "AEDFHR";
		int ans = test.getLongestCommonSubsequence(a, b);
		System.out.println(ans);
		
		ans = test.getLongestCommonSubsequence_on_model(a, b);
		System.out.println(ans);
	}

}
