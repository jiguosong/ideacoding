package tree;

import java.util.*;

public class searchRangeBST {
	
	public int[] searchRange(TreeNode root, int k) {
		int[] res = new int[2]; 
		if (root == null) return res;
		
		int high = Integer.MAX_VALUE;
		int low = Integer.MIN_VALUE;
		
		TreeNode p = root;
		
		while (p != null) {
			if (k == p.val) {
				low = k;
				high = k;
				break;
			}			
			if (k < p.val) {  // go left
				high = p.val;
				p = p.left;
			} else {         // go right
				low = p.val;
				p = p.right;				
			}
		}
		
		res[0] = low;
		res[1] = high;		
		return res;
	}
	
	public boolean isBST(TreeNode root) {
		if (root == null) return false;
		
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();		
		int cur = root.val;
		int pre = Integer.MIN_VALUE;
		
		TreeNode q = root;
		while (q != null) {
			stack.push(q);
			q = q.left;
		}
	
		while(!stack.isEmpty()) {
			q = stack.pop();
			//System.out.println(q.val);  //print BST in order
			cur = q.val;
			if (cur < pre) return false;
			pre = cur;
			TreeNode tmp = q.right;
			while (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
		}
		
		return true;
	}

	public boolean isBST_recur(TreeNode root) {
		if (root == null) return true;		
		return isBST_recur_helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean isBST_recur_helper(TreeNode root, int min, int max){
		if (root == null) return true;		
		if (root.val < min || root.val > max) return false;
		return isBST_recur_helper(root.left, min, root.val) && 
				isBST_recur_helper(root.right, root.val, max);
	}	
	
	
	/**
	 * @param args
	 */
	
	
    /*
     *                         5
     *                    /        \
     *                   2         40            
     *                  / \     /      \
     *                 1  3   10        50
     *                /         \      /  \
     *               -20         12   48  1000
     *                           /
     *                          11
     * 
     * 
     * */
	
	
	public static void main(String[] args) {
		System.out.println("Java: search range BST");		
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
		
		searchRangeBST test = new searchRangeBST();
		if (test.isBST_recur(root) == true) {
			System.out.println("is a BST (recur)");
		}
		
		if (test.isBST(root) == true) {
			//System.out.println("is a BST");
			int target = 111;
			int[] res = test.searchRange(root, target);		
			System.out.println("["+res[0]+", " + res[1] + "]");
			int closest = ((target-res[0]) > (res[1]-target)) ? res[1] : res[0];
			System.out.println("closer to "+closest);
		}
		else {
			System.out.println("not a BST");
		}
	}

}
