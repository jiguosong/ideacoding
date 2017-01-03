package others;

public class splitarraylargestsum {

	// Given an array which consists of non-negative integers and an integer m, 
	// you can split the array into m non-empty continuous subarrays. Write an 
	// algorithm to minimize the largest sum among these m subarrays.
	public int splitArray(int[] nums, int m) {
		if(nums == null || nums.length == 0) return 0;
		int res = 0;
		
		int min_res = 0;   // when m is nums.length
		int max_res = 0;   // when m is 1
		for(int i = 0; i < nums.length; i++) {
			min_res = Math.max(min_res, nums[i]);
			max_res = max_res + nums[i];
		}
		
		int left = min_res;
		int right = max_res;
		while(left < right) {
			int mid = left + (right-left)/2;
			if(isSplittable(nums, m, mid)) right = mid;
			else left = mid+1;			
		}
			
		return left;
	}
	
	private boolean isSplittable(int[] nums, int m, int sum) {
		int count = 1;
		int local_sum = 0;
		
		for(int i = 0; i < nums.length; i++) {
			local_sum += nums[i];
			if(local_sum > sum) {   // start a new group
				count++;
				if(count > m) return false;
				local_sum = nums[i];
			}
		}
		
		return true;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		splitarraylargestsum test = new splitarraylargestsum();
		int[] nums = {7,2,5,10,8};
		int m = 2;
		int ans = test.splitArray(nums, m);
		System.out.println(ans);

	}

}
