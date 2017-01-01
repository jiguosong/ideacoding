package dp;

public class maximumsubarray_sumprod {
	
	// I failed on this when I went to Samsuang Interview. Fuck!!!
	// here is the idea: s[i] is the max sum of subarray that ends at nums[i] (inclusive)
	// s[i+1] can only come from s[i]+num[i+1] or just nums[i]  (because 2 conditions need to be met: 1) include nums[i], 2) contiguous) 
	public int maxSum(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int n = nums.length; 
		int[] sum = new int[n];
		sum[0] = nums[0];
		int res = Integer.MIN_VALUE;
		
		for(int i = 1; i < n; i++) {
			sum[i] = Math.max(nums[i], sum[i-1]+nums[i]);
			res = Math.max(res, sum[i]);
		}
		
		return res;		
	}
		
	
	public int maxSubArraySum(int[] A) {
		if(A == null || A.length == 0) return 0;
		
		int[] sum = new int[A.length];
		sum[0] = A[0];
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i-1]+A[i]);
			max = Math.max(sum[i], max);
		}
		
		return max;
	}
		

	
	public int maxProd(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int n = nums.length; 
		int[] maxProd = new int[n];
		int[] minProd = new int[n];
		maxProd[0] = nums[0];
		minProd[0] = nums[0];
		int res = Integer.MIN_VALUE;
		
		for(int i = 1; i < n; i++) {
			if(nums[i] >= 0) {
				maxProd[i] = Math.max(nums[i], maxProd[i-1]*nums[i]);
				minProd[i] = Math.min(nums[i], minProd[i-1]*nums[i]);
			} else {
				maxProd[i] = Math.max(nums[i], minProd[i-1]*nums[i]);
				minProd[i] = Math.min(nums[i], maxProd[i-1]*nums[i]);
			}
			
			res = Math.max(res, maxProd[i]);
		}
		
		return res;
	}
	
	
	public int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0) return 0;

		int[] maxprod = new int[nums.length];
		int[] minprod = new int[nums.length];
		maxprod[0] = nums[0];
		minprod[0] = nums[0];
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] > 0) {
				maxprod[i] = Math.max(nums[i], maxprod[i-1]*nums[i]);
				minprod[i] = Math.max(nums[i], minprod[i-1]*nums[i]);
			} else {
				maxprod[i] = Math.max(nums[i], minprod[i-1]*nums[i]);
				minprod[i] = Math.max(nums[i], maxprod[i-1]*nums[i]);
			}
			
			max = Math.max(max, maxprod[i]);
		}
		
		return max;	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maximumsubarray_sumprod test = new maximumsubarray_sumprod();
		int[] A = {1,2,3,4, -1,10,-7};
		int ans = test.maxSubArraySum(A);		
		System.out.println(ans);
		ans = test.maxSum(A);
		System.out.println(ans);
		
		int[] B = {2,3,-2,4};
		ans = test.maxProduct(B);
		System.out.println(ans);
		ans = test.maxProd(B);
		System.out.println(ans);

	}

}
