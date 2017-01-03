package tree;

import java.util.*;

// same as catalan number
public class uniqueBST {
	public int numTrees(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++){
				dp[i] += dp[j]*dp[i-j-1]; 
			}
		}
		
		return dp[n];
	}
	
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		
	    if(n==0) return new ArrayList<TreeNode>();

	    helper(1, n, res);
	    
	    return res;
	}
	 
	public List<TreeNode> helper(int m, int n, List<TreeNode> res){
	    if(m>n){
	        res.add(null);
	        return res;
	    }
	 
	    for(int i=m; i<=n; i++){
	        List<TreeNode> ls = new ArrayList<TreeNode>();
	        helper(m, i-1, ls);
	        List<TreeNode> rs = new ArrayList<TreeNode>();
	        helper(i+1, n, rs);
	        for(TreeNode l: ls){
	            for(TreeNode r: rs){
	                TreeNode curr = new TreeNode(i);
	                curr.left=l;
	                curr.right=r;
	                res.add(curr);
	            }
	        }
	    }
	 
	    return res;
	}
	
	private void in_order_tras(TreeNode root) {
		if (root == null) return;

		in_order_tras(root.left);
		System.out.print(root.val);
		in_order_tras(root.right);
		
		return;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java:unique BST");
		uniqueBST test = new uniqueBST();
		int res = test.numTrees(3);		
		System.out.println(res);
		
		List<TreeNode> aa = test.generateTrees(3);
		System.out.println(aa.size());
		for (TreeNode t : aa) {
			test.in_order_tras(t);
			System.out.println("");
		}

	}

}
