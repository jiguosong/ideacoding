package tree;

import java.util.*;

public class kthsmallestinBST {
	private int cnt;
	public int kthSmallest(TreeNode root, int k) {
		if (root == null || k <= 0) return Integer.MIN_VALUE;
		cnt = k;
		int res[] = new int[1];
		helper(root, k, res);
		
		return res[0];
	}
	
	private void helper(TreeNode root, int k, int[] res) {
		if (root == null) return;	
		helper(root.left, k, res);
		if (--cnt == 0) {
			res[0] = root.val;
			return;
		}
		helper(root.right, k, res);
	}	
	
	
	public int kthSmallest_iterative(TreeNode root, int k) {
		if (root == null || k <= 0) return Integer.MIN_VALUE;

		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.push(root);
		TreeNode p = root;
		while(p.left != null) {
			stack.push(p.left);
			p = p.left; 
		}
		
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			k--;
			if (k == 0) return tmp.val;
			if(tmp.right != null) {
				stack.push(tmp.right);
				tmp = tmp.right;
				while(tmp.left != null) {
					stack.push(tmp.left);
					tmp = tmp.left; 
				}
			}			
		}
	
		return Integer.MIN_VALUE;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		kthsmallestinBST test = new kthsmallestinBST();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		
		int ans = test.kthSmallest(root, 3);
		System.out.println(ans);
		
		ans = test.kthSmallest_iterative(root, 3);
		System.out.println(ans);
		

	}

}
