package others;

public class findclosestinSortedArray {
	
	public int closestValue(int[] nums, double target) {
		if (nums == null || nums.length == 0) return 0;
		int res = 0;
		double min = Double.MAX_VALUE;
		double diff = 0;
		
		int left = 0;
		int right = nums.length-1;
		
		while(left <= right) {
			int mid = left + (right - left)/2;
			if (nums[mid] == target) return nums[mid];
			else if (target > nums[mid]) {  //go right
				diff = target - nums[mid];
				if (diff < min) {
					min = diff;
					res = nums[mid];
				}
				left = mid + 1;
			} else {  //go left
				diff = nums[mid] - target;
				if (diff < min) {
					min = diff;
					res = nums[mid];
				}
				right = mid - 1;
			}			
		}
		
		return res;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findclosestinSortedArray test = new findclosestinSortedArray();
		int[] nums = {1,2,3,4,5,6,7};
		double target = 5.1;
		int ans = test.closestValue(nums, target);
		System.out.println(ans);
		

	}

}
