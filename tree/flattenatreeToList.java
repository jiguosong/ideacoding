package tree;

import java.util.*;

public class flattenatreeToList {
	public TreeNode flatten(TreeNode root) {  
		if (root == null) return root; 		
		TreeNode tmp_right = root.right;
		
		if (root.left != null) {
			root.right = root.left;
			root.left = null;
			root = flatten(root.right);
		}
		
		if (tmp_right != null) {
			root.right = tmp_right;
			root = flatten(root.right);
		}		
		return root;
	}  

	public TreeNode flatten_iterative(TreeNode root) {  
		if (root == null) return root; 
		
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode curr = root;
		while(curr != null) {
			while (curr.left != null) {
				if (curr.right != null) stack.push(curr.right);
				curr.right = curr.left;
				curr.left = null;
				curr = curr.right;
			}
			
			if (curr != null && curr.right == null && !stack.isEmpty()) {
				TreeNode tmp = stack.pop();
				curr.right = tmp;
			}
			
			curr = curr.right;
		}
		
		return root;
	}
	
	public TreeNode flatten_iterative_nostack(TreeNode root) {
		if (root == null) return root;
		
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left !=null) {
				if (curr.right != null) {
					TreeNode tmp = curr.left;
					while (tmp.right != null) tmp = tmp.right;
					tmp.right = curr.right;
				}			
				curr.right = curr.left;
				curr.left = null;
			}
			
			curr = curr.right;
		}
		
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);		
		
		flattenatreeToList test = new flattenatreeToList();
		//test.flatten(root);
		//test.flatten_iterative(root);
		test.flatten_iterative_nostack(root);
		
		while(root!=null) {
			System.out.print(root.val);
			root = root.right;
		}
	}

}
