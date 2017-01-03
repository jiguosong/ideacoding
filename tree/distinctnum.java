package tree;

import java.util.*;

public class distinctnum {
	// I failed this on Samsung interview, fuck!!!
	// find max consecutive distinc numbers in a tree (no more than 4 distinct numbers)
	public int distincNum(TreeNode root) {
		if(root == null) return 0;
		int res = 0;		
		
		Set<Integer> set = distincNum_helper(root);
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) System.out.println(it.next());
				
		res = set.size();
		return res;
	}
	
	private Set<Integer> distincNum_helper(TreeNode root) {
		if(root == null) return new HashSet<Integer>();
		
		Set<Integer> left = distincNum_helper(root.left);
		Set<Integer> right = distincNum_helper(root.right);
		
		left.add(root.val);
		right.add(root.val);
		Set<Integer> parent = new HashSet<Integer>();	
		if(left.size() > right.size()) parent.addAll(left);
		else parent.addAll(right);
		
		return parent;		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		distinctnum test = new distinctnum();
		System.out.println("distinc num");
		
		TreeNode root = new TreeNode(1);
		
		root.right = new TreeNode(4);		
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(1);
		root.right.right.right = new TreeNode(6);
		root.right.right.right.right = new TreeNode(2);
		root.right.right.right.right.right = new TreeNode(7);
		
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(5);
		root.left.left.left = new TreeNode(5);
		
		int ans = test.distincNum(root);
		System.out.println();
		System.out.println(ans);
		 

	}

}
