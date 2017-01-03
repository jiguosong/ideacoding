package others;

import java.util.*;

public class maximumSumSubarrayClosetoK {
	
	public int getLargestSumCloseToK(int[] arr, int k){
		if(arr == null || arr.length == 0) return 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int res = 0;
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];			
			Integer ceiling = set.ceiling(sum-k);
			if (ceiling != null) {
				max = Math.max(max, sum - ceiling);
				res = max;
			}
			
			set.add(sum);
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maximumSumSubarrayClosetoK test = new maximumSumSubarrayClosetoK();
		int[] arr = { 3, 5, 6, 9, 14, 8, 2, 12, 7, 7 };
		int k = 21;
		int ans = test.getLargestSumCloseToK(arr, k);
		System.out.println(ans);
	}

}
