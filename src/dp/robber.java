package dp;

import java.util.Arrays;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {val = x;}
}

public class robber {
	
	// housese are in a row
	public int rob_row(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int n = nums.length;
		int[] maxProf = new int[n+1];
		maxProf[0] = 0;
		maxProf[1] = nums[0];
		
		for(int i = 2; i <= n; i++) {
			maxProf[i] = Math.max(maxProf[i-1], maxProf[i-2]+nums[i-1]);
		}
		
		return maxProf[n];		
	}
	
	// housese are in a row, and the last one and the first one is adjacent
	public int rob_circle(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int n = nums.length;
		int[] nums1 = Arrays.copyOfRange(nums, 0, n-1);
		int[] nums2 = Arrays.copyOfRange(nums, 1, n);
		int p1 = rob_row(nums1);
		int p2 = rob_row(nums2);
		
		return Math.max(p1, p2);		
	}
	
	// houses are in a tree (think in bottom up way in my model, either jump to the root from its chidlren, or not)
	public int rob_tree(TreeNode root) {
		if(root == null) return 0;
		
		int[] robbed = new int[2];
		robbed = rob_tree_helper(root);		
		
		return Math.max(robbed[0], robbed[1]);
	}
	
	private int[] rob_tree_helper(TreeNode root) {
		if(root == null) return new int[2];
		
		int[] robbed_left = rob_tree_helper(root.left);
		int[] robbed_right = rob_tree_helper(root.right);
		
		int[] robbed = new int[2];
		robbed[0] = root.val + robbed_left[1] + robbed_right[1];  // rob the root
		robbed[1] = Math.max(robbed_right[0], robbed_right[1]) +  // not rob the root
					Math.max(robbed_left[0], robbed_left[1]);
		
		return robbed;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		robber test = new robber();
		int[] nums = {10,2,3,4,5};
		int ans;
		ans = test.rob_row(nums);
		System.out.println(ans);

		ans = test.rob_circle(nums);
		System.out.println(ans);
		
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(3);		
		
/*		root.right = new TreeNode(5);		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);		
		root.right.right = new TreeNode(1)*/;
		
		ans = test.rob_tree(root);
		System.out.println(ans);

	}

}
