/*

*/

package tree.deleteNodeinBST;

import tree.TreeNode;

public class deleteNodeinBST {
    public TreeNode DeleteBSTNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val < key) {
            root = DeleteBSTNode(root.right, key);
        } else if (root.val > key) {
            root = DeleteBSTNode(root.left, key);
        } else {
            if (root.left == null || root.right == null) root = root.right == null ? root.left : root.right;
            else {
                TreeNode p = root.right;
                while (p.left != null) p = p.left;
                root.val = p.val;
                root.right = DeleteBSTNode(root.right, p.val);
            }
        }
        return root;
    }
}