package tree;

import java.util.Iterator;
import java.util.List;

public class isSymmetricBT {
	
	public boolean isSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) return true;
		if (root1 == null) return false;
		if (root2 == null) return false;
		
		if (root1.val != root2.val) return false;
		
		return isSame(root1.left, root2.left) &&
				isSame(root1.right, root2.right);		
	}

	
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		
		return 	isSymmetric_helper(root, root);	
	}
	
	private boolean isSymmetric_helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (right == null) return false;
		if (left == null) return false;
		
		if (left.val != right.val) return false;
		
		return isSymmetric_helper(left.left, right.right) &&
				isSymmetric_helper(left.right, right.left);		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		isSymmetricBT test = new isSymmetricBT();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);		
		
		AllTraverseTree travese = new AllTraverseTree();
		
		List<List<Integer>> res = travese.levelOrder(root);		
		Iterator<List<Integer>> it = res.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		
		System.out.println();
		if (test.isSymmetric(root)) System.out.println("Symmetric");
		else  System.out.println("Not symmetric");

	}

}
