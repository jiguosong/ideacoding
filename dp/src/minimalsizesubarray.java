package dp.src;

public class minimalsizesubarray {
/*	
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s
*/
	// can not use DP, since there is no sub-optimal solution
	// NO!!! we can still use DP model to think about it
	// like a worm eating
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		int sum = 0;
		int tail = 0;
		int head = 0;
		
		int min_len = Integer.MAX_VALUE;
		
		while(head < nums.length) {
			if (sum < s) {
				sum += nums[head];
				head++;
			} else {
				min_len = Math.min(min_len, head - tail);				
				if (min_len == 1) return 1;
				sum -= nums[tail];
				tail++;				
			}
		}
		
		// no more to eat, and the body is still longer than s
		while(sum >= s) {
			min_len = Math.min(min_len, head - tail);	
			if (min_len == 1) return 1;
			sum -= nums[tail];
			tail++;
		}
		
		if (min_len == Integer.MAX_VALUE) return 0;
		else return min_len;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		minimalsizesubarray test = new minimalsizesubarray();
		int s = 7;
		int[] nums = {2,3,1,2,4,3};
		int ans = test.minSubArrayLen(s, nums);
		System.out.println(ans);
	}

}
