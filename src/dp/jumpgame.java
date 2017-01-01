package dp;

public class jumpgame {
	public boolean canJump_on_model(int[] A) {
		if(A == null || A.length == 0) return false;
		
		int farest = 0;	
		for(int i = 0; i < A.length; i++) {
			if(i > farest || farest >= A.length-1) break;
			farest = Math.max(farest, A[i] + i);
		}
		
		return 	farest >= A.length-1;
	}
	
	public int jump_on_model(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
	
		int pre_far = 0;   // set the first range, then find the farest destination we can jump to from within this range
		int farest = 0;    // once we are out of current range, we need increase a step, say jump to the following farest destination
		int steps = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i > pre_far) {
				steps++;
				pre_far = farest;
			}
			farest = Math.max(farest, nums[i]+i);
		}
		
		if(farest < nums.length-1) return -1;
		return steps;		
	}
	
	public int jump(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int curr_far = 0;
		int prev_far = 0;
		int steps = 0;
		int n = nums.length-1;
		int i = 0;
		
		while(curr_far < n-1) {
			prev_far = curr_far;
			while(i <= prev_far) {
				curr_far = Math.max(curr_far, nums[i]+i);
				i++;
			}
			
			if(prev_far == curr_far) return -1;
			steps++;
		}
		
		return steps;
	}
	
	
	public boolean canJump(int[] A) {
		if(A == null || A.length == 0) return false;
		
		int[] dp = new int[A.length];
		dp[0] = A[0];
		
		for(int i = 1; i < A.length; i++) {
			dp[i] = Math.max(dp[i-1], A[i-1]) - 1;
		}
		
		return dp[A.length-1] >= 0;		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		jumpgame test = new jumpgame();
		int[] A = {2,3,1,1,4};
		int[] B = {3,2,1,0,4};
		
		if(test.canJump(A)) System.out.println("can jump");
		else System.out.println("can not jump");
		
		if(test.canJump_on_model(A)) System.out.println("can jump");
		else System.out.println("can not jump");

		int ans = test.jump(A);
		System.out.println(ans);
		ans = test.jump_on_model(A);
		System.out.println(ans);
		
	}

}
