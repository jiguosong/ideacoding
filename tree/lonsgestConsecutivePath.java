package tree;

import java.util.Iterator;
import java.util.List;

/*
 *   3-4-5 is the longest one, so ans is 3
1
\
 3
/ \
2   4
    \
     5
     
*/
public class lonsgestConsecutivePath {

	private int maxLen = 0;

	public int longestConsecutive(TreeNode root) {
		if (root == null) return 0;
		longestConsecutive_helper(root);		 
		return maxLen;
	}
	 
	 private int longestConsecutive_helper(TreeNode root) {
		 if (root == null) return 0;
		 
		 int l_len = longestConsecutive_helper(root.left);
		 int r_len = longestConsecutive_helper(root.right);
		 
		 int left_path = 0;
		 int right_path = 0;
		 
		 if (root.left != null && root.left.val == root.val + 1) left_path = l_len+1;
		 else left_path = 1;
		 
		 if (root.right != null && root.right.val == root.val + 1) right_path = r_len+1;
		 else right_path = 1;
		 
		 int maxCurr = Math.max(left_path, right_path);
		 maxLen = Math.max(maxLen, maxCurr);
		 
		 return maxCurr;
	 }
	 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		lonsgestConsecutivePath test = new lonsgestConsecutivePath();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);	
		root.right.left.left = new TreeNode(7);
		root.right.left.left.right = new TreeNode(8);
		root.right.left.left.right.left = new TreeNode(9);
		root.right.left.left.right.left.right = new TreeNode(10);
		
		
		AllTraverseTree traverse = new AllTraverseTree();
		System.out.println("level order traverse");
		List<List<Integer>> res = traverse.levelOrder(root);		
		Iterator<List<Integer>> it = res.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}

		
		int ans = test.longestConsecutive(root);
		
		System.out.println();
		System.out.println(ans);

	}

}
