package tree;

import java.util.Iterator;
import java.util.List;

public class largestBST {
	class TreeNodeWrapper {
		int lower;
		int upper;
		int size;
		boolean isBST;
		
		TreeNodeWrapper() {
			this.lower = Integer.MAX_VALUE;
			this.upper = Integer.MIN_VALUE;
			this.size = 0;
			this.isBST = false;			
		}
	}
	
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0; 
		TreeNodeWrapper res = largestBSTSubtree_helper(root);		
		return res.size;
	}
	
	private TreeNodeWrapper largestBSTSubtree_helper(TreeNode root) {
		TreeNodeWrapper curr = new TreeNodeWrapper();
		
		if (root == null) {
			curr.isBST = true;
			return curr;
		}

		TreeNodeWrapper left = largestBSTSubtree_helper(root.left);
		TreeNodeWrapper right = largestBSTSubtree_helper(root.right);
		
		curr.lower = Math.min(left.lower, root.val);
		curr.upper = Math.max(right.upper, root.val);
		
		if (left.isBST && right.isBST && root.val >= left.upper && root.val <= right.lower) {
			curr.size = left.size + right.size + 1;
			curr.isBST = true;			
		} else {
			curr.size = Math.max(left.size, right.size);
			curr.isBST = false;
		}
		
		return curr;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		largestBST test = new largestBST();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		AllTraverseTree traverse = new AllTraverseTree();
		
		System.out.println("level order traverse");
		List<List<Integer>> res = traverse.levelOrder(root);		
		Iterator<List<Integer>> it = res.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		
		int maxBSTsz = test.largestBSTSubtree(root);
		System.out.println();
		System.out.println(maxBSTsz);

	}

}
