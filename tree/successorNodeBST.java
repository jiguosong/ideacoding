package tree;

import java.util.Iterator;
import java.util.List;

public class successorNodeBST {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) return null;
		
		TreeNode k = root;
		TreeNode prev = null;
		while(k != null) {
			if (k.val == p.val) break;
			else if (k.val < p.val) k = k.right;
			else if (k.val > p.val) {
				prev = k;
				k = k.left;
			}
		}
		
		if (k == null) return null;
		if (k.right == null) return prev;
		
		k = k.right;
		while(k.left != null) k = k.left;
		
		return k;	
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		successorNodeBST test = new successorNodeBST();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		
		AllTraverseTree traverse = new AllTraverseTree();
		
		System.out.println("level order traverse");
		List<List<Integer>> res = traverse.levelOrder(root);		
		Iterator<List<Integer>> it = res.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		
		TreeNode p = new TreeNode(5);
		
		TreeNode ans = test.inorderSuccessor(root, p);		
		if (ans != null) System.out.println(ans.val);
	}

}
