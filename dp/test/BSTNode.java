package dp.test;

/**
 * Created by songjiguo on 1/2/17.
 */
class BSTNode {
	int val;
	int smaller;
	BSTNode left, right;

	BSTNode(int val, int smaller){
		this.val = val;
		this.smaller = smaller;
		this.left = null;
		this.right = null;
	}
}
