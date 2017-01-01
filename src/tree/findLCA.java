package tree;

import java.util.*;

class TreeNode_Parent_Ptr {
	int val;
	TreeNode_Parent_Ptr left;
	TreeNode_Parent_Ptr right;
	TreeNode_Parent_Ptr parent;
	
	TreeNode_Parent_Ptr(int val) {
		this.val = 0;
		this.left = null;
		this.right = null;
		this.parent = null;		
	}
}


public class findLCA {
	
	private int getHight(TreeNode_Parent_Ptr node) {
		if (node ==null) return 0;
		int hight = 0;
		while(node != null) {
			node = node.parent;
			hight++;
		}
		return hight;
	}
	
	
	public TreeNode_Parent_Ptr lowestCommonAncestor_BT_parent(TreeNode_Parent_Ptr root, TreeNode_Parent_Ptr p, TreeNode_Parent_Ptr q) {
		if (root == null || p == null || q ==null) return null;	
		
		int h1 = getHight(p);
		int h2 = getHight(q);
		
		int diff = Math.abs(h1-h2);
		
		int step = 0;
		if (h1 > h2) {
			while(step++ < diff) p = p.parent;
		} else {
			while(step++ < diff) q = q.parent;
		}
		
		while(p != q) {
			p = p.parent;
			q = q.parent;
		}
			
		return p;
    }
	

	public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q ==null) return null;

		if (p.val > q.val) return lowestCommonAncestor_BST(root, q, p);  // p is always smaller
		else if (p.val <= root.val && q.val >= root.val) return root;
		else if (p.val < root.val && q.val < root.val) return lowestCommonAncestor_BST(root.left, q, p);
		else return lowestCommonAncestor_BST(root.right, q, p); // if (p.val > root.val && q.val > root.val)
        
    }
	
	
	public TreeNode lowestCommonAncestor_BT(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q ==null) return null;
		if (root == p || root == q) return root;
		
		TreeNode left = lowestCommonAncestor_BT(root.left, p, q);
		TreeNode right = lowestCommonAncestor_BT(root.right, p, q);
		
		if (left != null && right != null) return root;
		if (left == null && right == null) return null;
		
		if (left != null) return left;
		else return right;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java:LCA BST");
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);		

		findLCA test = new findLCA();
		TreeNode res = test.lowestCommonAncestor_BST(root, root.right.left, root);  // 4 and 2
		System.out.println(res.val);
		
		System.out.println("Java:LCA BT");
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(32);
		root2.right = new TreeNode(40);
		root2.right.left = new TreeNode(-3);
		root2.right.right = new TreeNode(100);		
		
		TreeNode res2 = test.lowestCommonAncestor_BT(root2, root2.right.right, root2.right.left);  // 100 and -3
		System.out.println(res2.val);

	}

}
