package dp.src;

import java.util.Arrays;

public class candy {
	public int candysolver(int[] ratings) {
		if (ratings == null || ratings.length == 0) return 0;
		int res = 0;
		
		int[] candy = new int[ratings.length];
		Arrays.fill(candy, 1);
		
		// left to right
		for (int i = 1; i < ratings.length ; i++) {
			if (ratings[i] > ratings[i-1]) candy[i] = candy[i-1] + 1;
		}
		
		// right to left
		for (int i = ratings.length - 2; i > 0 ; i--) {
			if (ratings[i] > ratings[i+1] && candy[i] < candy[i+1]) candy[i] = candy[i+1] + 1;
		}
		
		for (int i = 0; i < ratings.length ; i++) {
			res += candy[i];
		}
		
		return res;
	}

//	/**
//	 * @param args
//	 */
//	public static void src(String[] args) {
//		candy test = new candy();
//		int[] ratings = {1,2,0,1,2,3,2};
//		int ans = test.candysolver(ratings);
//		System.out.println(ans);
//
//	}

}
