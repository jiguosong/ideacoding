package others;

import java.util.Arrays;

public class countingSort {
	
	// n objects colored red, white or blue, sort them in color
	public void sortColors(int[] nums) {
		if(nums == null || nums.length < 2) return;
		
		int[] count  = new int[3];
		int[] res = new int[nums.length];
		
		for(int e:nums) count[e]++;
		
		for(int i = 1; i < 3 ; i++) count[i] = count[i] + count[i-1];
		
		for(int i = nums.length - 1; i >= 0 ; i--) {
			int idx = count[nums[i]]-1;
			res[idx] = nums[i];
			count[nums[i]]--;
		}
		
		System.arraycopy(res, 0, nums, 0, nums.length);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		countingSort test = new countingSort();
		int[] nums = {0,1,2,0,1,0,0,2,2,1,1,1,1,0,2,1,0};
		test.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

}
