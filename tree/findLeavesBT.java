package tree;

import java.util.*;

public class findLeavesBT {

	public List<List<Integer>> findLeaves(TreeNode root) {
		if (root == null) return null;
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		
		findLeaves_helper(root, tmp, res);
		
		return res;		
	}
	
	private int findLeaves_helper(TreeNode root, List<Integer> tmp, List<List<Integer>> res) {
		if (root == null) return 0;
		
		int left_h = findLeaves_helper(root.left, tmp, res);
		int right_h = findLeaves_helper(root.right, tmp, res);
		int height = Math.max(left_h, right_h) + 1;  // start from 1
		
		if (res.size() < height) {  // reach to a new level
			List<Integer> p = new ArrayList<Integer>();
			res.add(p);
		}
		
		res.get(height-1).add(root.val);	
		
		return height;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findLeavesBT test = new findLeavesBT();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);		
		
		AllTraverseTree traverse = new AllTraverseTree();
		
		System.out.println("level order traverse");
		List<List<Integer>> res = traverse.levelOrder(root);		
		Iterator<List<Integer>> it = res.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}

		List<List<Integer>>  ans = test.findLeaves(root);
		
		System.out.println();
		it = ans.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
	}

}
