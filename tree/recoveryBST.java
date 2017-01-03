package tree;

public class recoveryBST {
	private  TreeNode first;
	private  TreeNode second;
	private  TreeNode prev;	
	
	recoveryBST(){
		this.first = null;
		this.second = null;
		this.prev = null;
	}
	
    public void recoverTree(TreeNode root) {
        if (root == null) return;

        recoverTree_dfs_helper(root);
        
        if (first != null && second != null) swap_treenode(first, second);
        
        System.out.println(" ");
        recoverTree_dfs_helper(root);
        
        return;
    }

	private void recoverTree_dfs_helper(TreeNode root) {
		if (root == null) return;
		
		if (root.left != null) recoverTree_dfs_helper(root.left);
		
		System.out.print(root.val);
	
		if (prev != null && prev.val > root.val) {
			if (first == null) {
				first = prev;
			} else {
				second = root;
			}
		}
		prev = root;
		
		if (root.right != null) recoverTree_dfs_helper(root.right);
	}
	
	private void swap_treenode(TreeNode first, TreeNode second) {
		if (first == null || second == null) return;
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
		
		return;	
	}

	public boolean sameBST(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) return true;
		if (tree1 == null && tree2 != null) return false;
		if (tree1 != null && tree2 == null) return false;

		return (tree1.val == tree2.val) &&
				(sameBST(tree1.left, tree2.left)) &&
				(sameBST(tree1.right, tree2.right));
	}
	
	private boolean symmetricBST(TreeNode root) {
		if (root == null) return true;
		
		return symmetricBST_helper(root.left, root.right);		
	}
	private boolean symmetricBST_helper(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) return true;
		if (tree1 == null && tree2 != null) return false;
		if (tree1 != null && tree2 == null) return false;

		return (tree1.val == tree2.val) &&
				(symmetricBST_helper(tree1.left, tree2.right)) &&
				(symmetricBST_helper(tree1.right, tree2.left));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java: recover BST");		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);

		recoveryBST test = new recoveryBST();
		test.recoverTree(root);
		
	
		System.out.println("\nJava: same BST");
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(4);
		root1.right = new TreeNode(1);
		root1.right.left = new TreeNode(3);
		root1.right.right = new TreeNode(5);

		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(4);
		root2.right = new TreeNode(1);
		root2.right.left = new TreeNode(3);
		root2.right.right = new TreeNode(5);
		
		if (test.sameBST(root1, root2) == true) System.out.println("yes");
		else System.out.println("no");
		
		System.out.println("\nJava: symmetric BST");
		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2);
		root3.right = new TreeNode(2);
		root3.right.left = new TreeNode(4);
		root3.right.right = new TreeNode(3);
		root3.left.left = new TreeNode(3);
		root3.left.right = new TreeNode(4);

		if (test.symmetricBST(root3)== true) System.out.println("yes");
		else System.out.println("no");
		

	}

}
