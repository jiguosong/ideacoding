package dp;

import java.util.Arrays;

public class perfectsquares {
	public int numSquares_on_model(int n) {
		if(n <=0) return -1;

		int[] num_sqrt = new int[n+1];
		Arrays.fill(num_sqrt, Integer.MAX_VALUE);
		num_sqrt[0] = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= (int)Math.sqrt(n); j++) {
				if(j*j == i) num_sqrt[i] = 1; 
				else if(i > j*j) num_sqrt[i] = Math.min(num_sqrt[i], num_sqrt[i-j*j]+1);
			}
		}
		
		return num_sqrt[n];		
	}
	
	
	public int numSquares(int n) {
		if(n <=0) return -1;
		
		int res = 0;
		int[] min_squres_forvalue = new int[n+1];
		min_squres_forvalue[0] = 0;
		
		int max_squares_num = (int) Math.sqrt(n);
		
		for(int i = 1; i <= n; i++) {
			min_squres_forvalue[i] = n+1;  // just make it more than n, say Integer.MAX
			for(int j = 1; j <= max_squares_num; j++) {
				if(i > j*j) {
					min_squres_forvalue[i] = Math.min(min_squres_forvalue[i], min_squres_forvalue[i-j*j] + 1);
				} else if(i == j*j) min_squres_forvalue[i] = 1;
			}
		}
		
		if(min_squres_forvalue[n] > n) res = -1;   // see above comment
		else res = min_squres_forvalue[n];
		
		return res;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		perfectsquares test = new perfectsquares();
		int n = 12;		
		int ans = test.numSquares(n);
		System.out.println(ans);

		ans = test.numSquares_on_model(n);
		System.out.println(ans);

	}

}
