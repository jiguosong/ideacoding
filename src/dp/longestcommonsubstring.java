package dp;

/*This is a similar problem like longest common subsequence. The difference of the solution is that for this problem 
when a[i]!=b[j], dp[i][j] are all zeros by default. However, in the longest common subsequence problem, dp[i][j] 
values are carried from the previous values, i.e., dp[i-1][j] and dp[i][j-1].*/

public class longestcommonsubstring {
	public int getLongestCommonSubstring_on_model(String a, String b){
		if(a == null || a.length() == 0) return 0;
		if(b == null || b.length() == 0) return 0;
		
		int m = a.length();
		int n = b.length();
		
		int[][] lcs = new int[m+1][n+1];
		lcs[0][0] = 1;
		int max = 0;
		
		for(int i = 1; i <= m; i++) {
			char c1 = a.charAt(i-1);
			for(int j = 1; j <= n; j++) {
				char c2 = b.charAt(j-1);
				if(c1 == c2) {
					if(i == 1 || j ==1) lcs[i][j] = 1;
					else lcs[i][j] = lcs[i-1][j-1] + 1;
				} 
				
				max = Math.max(lcs[i][j], max);
			}
		}
		
		return max;
	}
	
	public int getLongestCommonSubstring(String a, String b){
		if(a == null || a.length() == 0) return 0;
		if(b == null || b.length() == 0) return 0;
		
		int res = Integer.MIN_VALUE;
		int m = a.length();
		int n = b.length();
		
		int[][] dp = new int[m][n];
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j ++) {
				if(a.charAt(i) == b.charAt(j)) {
					if(i == 0 || j == 0) dp[i][j] = 1;
					else dp[i][j] = dp[i-1][j-1] +1;
					
					res = Math.max(dp[i][j], res);
				}
			}
		}
		
		return res;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		longestcommonsubstring test = new longestcommonsubstring();
		String a =  "OldSite:GeeksforGeeks.org";
		String b = "NewSite:GeeksQuiz.com";
		int ans = test.getLongestCommonSubstring(a, b);
		System.out.println(ans);
		
		ans = test.getLongestCommonSubstring_on_model(a, b);
		System.out.println(ans);


	}

}
