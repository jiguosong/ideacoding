package tree;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class validateBST {
    public boolean isValidBST_1(TreeNode root) {  // in order
        if (root == null) return true;
        
    	Deque<TreeNode> s = new ArrayDeque<TreeNode>();
    	TreeNode p = root;
    	while(p != null) {
    		s.push(p);
    		p = p.left;
    	}
    	TreeNode pre = null;
    	TreeNode cur;
    	while(!s.isEmpty()) {
    		TreeNode t = s.pop();
    		cur = t;
    		
    		if (pre != null && cur.val < pre.val) return false;
    		
    		if (t != null) {
    			p = t.right;
    	    	while(p != null) {
    	    		s.push(p);
    	    		p = p.left;
    	    	}
    		}
    		
    		pre = cur;
    	}   	
    	
    	return true;
    }
    
    
    public boolean isValidBST_2(TreeNode root) {  // min max method
    	return isValidBST_2_helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST_2_helper(TreeNode root, int min, int max) {
    	if (root == null) return true;    
   	
    	if (root.val < min || root.val > max) return false; 

    	return isValidBST_2_helper(root.left, min, root.val) &&
    		    isValidBST_2_helper(root.right, root.val, max);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java:validate BST");
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		
		System.out.println("Java:validate BST method 1");
		validateBST test = new validateBST();
		if (test.isValidBST_1(root) == true) System.out.println("Yes");
		else System.out.println("No");

		System.out.println("Java:validate BST method 2");
		validateBST test2 = new validateBST();
		if (test.isValidBST_2(root) == true) System.out.println("Yes");
		else System.out.println("No");

	}
}