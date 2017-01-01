package tree;

import java.util.Iterator;
import java.util.List;

// For this problem, a height-balanced binary tree is defined as a binary tree in which the 
// depth of the two subtrees of every node never differ by more than 1
public class isBalancedBT {
	
	private int getHeight(TreeNode root) {
		if (root == null) return 0;		
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		
		if (left == -1 || right == -1 || Math.abs(left-right) > 1) return -1;
		
		return Math.max(left, right) + 1;
	}
	
	public boolean isBalanced(TreeNode root) {
		if (root == null) return false;
		
		if (getHeight(root) == -1) return false;
		else return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		isBalancedBT test = new isBalancedBT();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);	
		
		root.right.left.left= new TreeNode(8);
		root.right.left.left.left= new TreeNode(9);
		root.right.left.left.left.right= new TreeNode(10);
				
		AllTraverseTree traverse = new AllTraverseTree();
		List<List<Integer>> ans = traverse.levelOrder(root);	
		Iterator<List<Integer>> it = ans.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		System.out.println();
		
		int res = test.getHeight(root);
		boolean isB = test.isBalanced(root);
		System.out.println("Height: "+res);
		if (isB) System.out.println("Balanced");
		else System.out.println("Not Balanced");
	}

}
