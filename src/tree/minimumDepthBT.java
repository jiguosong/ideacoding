package tree;

import java.util.*;

public class minimumDepthBT {
	public int minDepth(TreeNode root) {
		  if(root == null) return 0;
		  int depth = 0;
		  
		  Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		  queue.add(root);
		  
		  while(!queue.isEmpty()) {
			  int sz = queue.size();
			  if(sz == 0) break;
			  depth++;
			  for(int i = 0; i < sz; i++) {
				  TreeNode tmp = queue.remove();
				  if(tmp.left == null && tmp.right == null) return depth;
				  if(tmp != null && tmp.left != null) queue.add(tmp.left);
				  if(tmp != null && tmp.right != null) queue.add(tmp.right);				  
			  }			  
		  }
		  
		  return depth;
	 }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		minimumDepthBT test = new minimumDepthBT();
		
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

		int maxPathsum = test.minDepth(root);
		System.out.println(maxPathsum);
	}

}
