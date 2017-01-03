package others;

import java.util.*;

public class summaryRange {
	
	public List<String> summaryRanges(int[] nums) {
		if(nums == null || nums.length == 0) return null;
		
		List<String> res = new ArrayList<String> ();
		
		int i = 0;
		while(i <  nums.length) {
			int j = 1;
			while(i+j < nums.length && nums[i+j] - nums[i] == j) j++;
			if(j == 1) res.add(String.valueOf(nums[i]));
			else res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[i+j-1]));  // above j++ need to reduce by 1 here
			i = i + j;  // above j++ does not need to reduce by 1 here
		}
				
		return res;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		summaryRange test = new summaryRange();
		int[] nums = {1,2,3,5,6,9};
		List<String> ans = test.summaryRanges(nums);
		System.out.println(ans);
	}

}
