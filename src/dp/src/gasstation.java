package dp.src;

public class gasstation {
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas == null || gas.length ==0) return -1;
		if(cost == null || cost.length ==0) return -1;
		
		int start = 0;
		int prev_remainder = 0;
		int total = 0;
		
		for(int i = 0; i < gas.length; i++) {			
			int diff = gas[i] - cost[i];
			if(prev_remainder >= 0) {
				prev_remainder += diff;    // update the current remainder
			} else {                      
				prev_remainder = diff;     // can not be covered by the previous remainder, so can not reach to i from previous station
				start = i;				
			}
			
			total += diff;
		}
		
		if(total >= 0) return start;
		else return -1;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		gasstation test = new gasstation();
		int[] gas = {3, 1, 2, 5, 4};
		int[] cost = {4, 1, 1, 2, 3};
		int ans = test.canCompleteCircuit(gas, cost);
		System.out.println(ans);

	}

}
