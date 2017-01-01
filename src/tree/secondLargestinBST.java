package tree;

import java.util.*;

public class secondLargestinBST {
	int level;
	
	public int findSecondLargest(TreeNode root) {
		if (root == null) return Integer.MIN_VALUE;

		int[] ans = new int[1];
		level = 0;
		findSecondLargest_helper(root, ans);
		
		return ans[0];
	}
	
	private void findSecondLargest_helper(TreeNode node, int[] ans) {
		if (node == null) return;
		if (level >= 2) return;
		
		findSecondLargest_helper(node.right, ans);
		
		level++;
		if (level == 2) {
			ans[0] = node.val;
			return;
		}
		
		findSecondLargest_helper(node.left, ans);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		secondLargestinBST test = new secondLargestinBST();
		
		TreeNode root = new TreeNode(5);		
		root.left = new TreeNode(2);
		root.right = new TreeNode(40);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(50);
		
		root.left.left.left = new TreeNode(-20);
		root.right.left.right = new TreeNode(12);
		root.right.right.left = new TreeNode(48);
		root.right.right.right = new TreeNode(1000);

		root.right.left.right.left = new TreeNode(11);
		
		int ans = test.findSecondLargest(root);
		System.out.println(ans);
	}

}
