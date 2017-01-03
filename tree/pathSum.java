package tree;

import java.util.*;

import javax.swing.event.ListSelectionEvent;

import tree.TreeNode;

public class pathSum {
	public List<List<Integer>> allpathSum(TreeNode root, int sum) {
		if (root == null) return null;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		
		tmp.add(root.val);
		pathSum_helper(root, sum - root.val, tmp, res);
		return res;
	}
	
	public void pathSum_helper(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
		if (root == null) return;
		if (root.left == null && root.right == null && sum == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		
		if (root.left != null) {
			tmp.add(root.left.val);
			pathSum_helper(root.left, sum - root.left.val, tmp, res);
			tmp.remove(tmp.size()-1);
		}

		if (root.right != null) {
			tmp.add(root.right.val);
			pathSum_helper(root.right, sum - root.right.val, tmp, res);
			tmp.remove(tmp.size()-1);
		}

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		
		if (root.val == sum && root.left == null && root.right == null) return true;
		
		return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);		
	}
	
	public boolean hasPathSum_iterative(TreeNode root, int sum) {
		if (root == null) return false;
		
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		Deque<Integer> sumresults = new ArrayDeque<Integer>();		
		
		queue.offer(root);
		sumresults.offer(root.val);
		while(!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			int curr_sum = sumresults.poll();
			
			if (curr.left == null && curr.right == null && curr_sum == sum) return true; 
			
			if (curr.left != null) {
				queue.offer(curr.left);
				sumresults.offer(curr.left.val + curr_sum);
			}
			if (curr.right != null) {
				queue.offer(curr.right);
				sumresults.offer(curr.right.val + curr_sum);
			}			
		}
	
		return false;
	}
	
	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		int[] globalmax = new int[1];
		globalmax[0] = 0;
		
		maxPathSum_helper(root, globalmax);
		
		return globalmax[0];
	}
	
	private int maxPathSum_helper(TreeNode root, int[] globalmax) {
		if (root == null) return 0;
		
		int left_max = maxPathSum_helper(root.left, globalmax);
		int right_max = maxPathSum_helper(root.right, globalmax);		
		int curr_max = Math.max(left_max + root.val, right_max + root.val);
		curr_max = Math.max(curr_max, root.val);
		
		int tmp = Math.max(curr_max, left_max + root.val + right_max);
		globalmax[0] = Math.max(globalmax[0], tmp);		
		return curr_max;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		pathSum test = new pathSum();
		
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
		
		int sum = 8;
		
		//if (test.hasPathSum(root, sum) == true) System.out.println("Yes");
		//else System.out.println("No");

		//if (test.hasPathSum_iterative(root, sum) == true) System.out.println("Yes");
		//else System.out.println("No");

//		List<List<Integer>> ans = test.allpathSum(root, sum);
//		Iterator<List<Integer>> it = ans.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		
		AllTraverseTree traverse = new AllTraverseTree();
		List<List<Integer>> ans = traverse.levelOrder(root);	
		Iterator<List<Integer>> it = ans.iterator();
		while(it.hasNext()) {
			List<Integer> tmp = it.next();
			System.out.print(tmp);
		}
		System.out.println();

		int maxPathsum = test.maxPathSum(root);
		System.out.println(maxPathsum);


}

}
