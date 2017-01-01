package others;

import java.util.Arrays;

public class searchforRange {
	
	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) return null;

		int start_idx = 0;
		int end_idx = 0;
		int left = 0;
		int right = nums.length-1;
		while(left < right) {
			int mid = left + (right-left)/2;
			if(target > nums[mid]) left = mid+1;
			else if(target < nums[mid]) right = mid-1;
			else {
				int tmp = mid;
				while(tmp >=0 && nums[tmp] == target) tmp--;
				start_idx = tmp+1;
				
				tmp = mid;
				while(tmp < nums.length && nums[tmp] == target) tmp++;
				end_idx = tmp-1;
				break;
			}			
		}
		
		int[] res = new int[2];
		res[0] = start_idx;
		res[1] = end_idx;
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		searchforRange test = new searchforRange();
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] ans = test.searchRange(nums, target);
		
		System.out.println(Arrays.toString(ans));
	}

}
