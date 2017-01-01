package tree;

import java.util.*;

public class sumRoot2Leaf {

	public int sumNumbers(TreeNode root) {
		if (root == null) return 0;
		int sum = 0;
		
		List<List<TreeNode>> res = new ArrayList<List<TreeNode>>();
		List<TreeNode> tmp = new ArrayList<TreeNode>();
		
		tmp.add(root);
		sumNumbers_helper(root, tmp, res);
		
		Iterator<List<TreeNode>> it = res.iterator();
		while(it.hasNext()) {
			List<TreeNode> k = it.next();
			System.out.println();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < k.size(); i++) {
				System.out.print(" " + k.get(i).val);
				sb.append(String.valueOf(k.get(i).val));
			}		
			
			sum += Integer.valueOf(sb.toString());
		}

		return sum;		
	}
	
	private void sumNumbers_helper(TreeNode root, List<TreeNode> tmp, List<List<TreeNode>> res) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			res.add(new ArrayList<TreeNode>(tmp));
			return;
		}		
		tmp.add(root.left);
		sumNumbers_helper(root.left, tmp, res);
		tmp.remove(tmp.size()-1);
		
		tmp.add(root.right);
		sumNumbers_helper(root.right, tmp, res);
		tmp.remove(tmp.size()-1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sumRoot2Leaf test = new sumRoot2Leaf();
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
		int ans = test.sumNumbers(root);
		System.out.println();
		System.out.println(ans);

	}

}
