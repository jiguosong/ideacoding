package tree;

import java.util.*;

public class invertBT {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode k = queue.poll();
			
			if (k.left != null) queue.offer(k.left);
			if (k.right != null) queue.offer(k.right);
			
			TreeNode tmp = k.left;
			k.left = k.right;
			k.right = tmp;			
		}
		
		return root;
	}
	
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) return null;
		
		invertTree2_helper(root);
		
		return root;
	}
	
	private void invertTree2_helper(TreeNode root) {
		if (root == null) return;

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;		
		
		invertTree2_helper(root.left);
		invertTree2_helper(root.right);
	}

		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		invertBT test = new invertBT();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);		
		
		TreeNode ans = test.invertTree(root);
		//TreeNode ans = test.invertTree2(root);
		
		AllTraverseTree traverse = new AllTraverseTree();		
		List<List<Integer>> res = traverse.levelOrder(ans);		
		Iterator<List<Integer>> it = res.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		

	}

}
