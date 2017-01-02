package dp.src;

import java.util.*;

public class longestIncreasingSubsequence {
	public int lengthOfLIS_on_model(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int lis = 0;
		int n = nums.length;
		int[] s = new int[n];
		Arrays.fill(s, 1);  // a single char is the min lis
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) s[i] = Math.max(s[i], s[j] + 1);
			}
			
			lis = Math.max(lis, s[i]);
		}
		
		return lis;		
	}
	
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int res = 0;
		int n = nums.length;
		int[] max_len_sofar = new int[n];
		Arrays.fill(max_len_sofar, 1);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					max_len_sofar[i] = Math.max(max_len_sofar[i], max_len_sofar[j] + 1);
				}
			}
			res = Math.max(res, max_len_sofar[i]);
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		longestIncreasingSubsequence test = new longestIncreasingSubsequence();
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int ans = test.lengthOfLIS(nums);
		System.out.println(ans);
		
		ans = test.lengthOfLIS_on_model(nums);
		System.out.println(ans);

	}

}
