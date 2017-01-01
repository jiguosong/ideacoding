package tree;

import java.util.Iterator;
import java.util.List;

public class countTreeNode {

	// for complete tree only
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int res = 0;
		
		int left_h = getLeftHeight(root);
		int right_h = getRightHeight(root);
		
		if (left_h == right_h) {
			res = (2 << left_h) -1;
			return res;
		} else {
			return countNodes(root.left) +	countNodes(root.right) + 1;	
		}
	}
	
	private int getLeftHeight(TreeNode root) {
		if (root == null) return 0;
		int res = 0;
		
		TreeNode p = root.left;
		while(p != null) {
			p = p.left;
			res++;
		}
		
		return res;		
	}
	
	private int getRightHeight(TreeNode root) {
		if (root == null) return 0;
		int res = 0;
		
		TreeNode p = root.right;
		while(p != null) {
			p = p.right;
			res++;
		}
		
		return res;		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		countTreeNode test = new countTreeNode();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		AllTraverseTree traverse = new AllTraverseTree();
		
		System.out.println("level order traverse");
		List<List<Integer>> res = traverse.levelOrder(root);		
		Iterator<List<Integer>> it = res.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		
		int ans = test.countNodes(root);
		System.out.println();
		System.out.println(ans);
		

	}

}
