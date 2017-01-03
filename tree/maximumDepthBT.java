package tree;

import java.util.Iterator;
import java.util.List;

public class maximumDepthBT {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return Math.max(left, right) + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		maximumDepthBT test = new maximumDepthBT();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(30);		

		root.left.right.left = new TreeNode(5);
		root.left.right.left.left = new TreeNode(20);
		root.left.right.left.left.right = new TreeNode(5);
				
		AllTraverseTree traverse = new AllTraverseTree();
		List<List<Integer>> ans = traverse.levelOrder(root);	
		Iterator<List<Integer>> it = ans.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		System.out.println();

		int maxPathsum = test.maxDepth(root);
		System.out.println(maxPathsum);
	}

}
