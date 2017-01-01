package dp;

import java.util.Arrays;

public class coinchanges {	
	public int coinChange_on_model(int[] coins, int amount) {
		if(coins == null || coins.length == 0 || amount <=0) return -1;
		
		int[] min_cosins_val = new int[amount+1];
		Arrays.fill(min_cosins_val, Integer.MAX_VALUE);
		min_cosins_val[0] = 0;
		
		for(int i = 0; i <= amount; i++) {
			for(int coin : coins) {   // each coin
				if(i+coin <= amount) {   // as long as stay within the boundary
					if(min_cosins_val[i] != Integer.MAX_VALUE) min_cosins_val[i+coin] = Math.min(min_cosins_val[i+coin], min_cosins_val[i]+1);
				}
			}
		}
		
		if(min_cosins_val[amount] == Integer.MAX_VALUE) return -1;
		else return min_cosins_val[amount];
		
	}
	
	public int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length == 0 || amount <=0) return -1;
		
		int res = 0;
		int[] min_coins_forvalue = new int[amount+1];
		min_coins_forvalue[0] = 0;
		
		for(int i = 1; i <= amount; i++) {
			min_coins_forvalue[i] = amount+1;  // just make it more than amount, say Integer.MAX
			for(int j = 0; j < coins.length; j++) {
				if(i >= coins[j]) {
					min_coins_forvalue[i] = Math.min(min_coins_forvalue[i], min_coins_forvalue[i-coins[j]] + 1);
				}
			}
		}
		
		if(min_coins_forvalue[amount] > amount) res = -1;   // see above comment
		else res = min_coins_forvalue[amount];
		
		return res;
	}
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		coinchanges test = new coinchanges();
		int[] coins = {1,2,5};
		int amount = 11;
		
		int ans = test.coinChange(coins, amount);
		System.out.println(ans);

		ans = test.coinChange_on_model(coins, amount);
		System.out.println(ans);

	}

}
