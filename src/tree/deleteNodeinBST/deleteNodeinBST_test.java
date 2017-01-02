package tree.deleteNodeinBST;

import org.junit.Test;
import tree.TreeNode;

public class deleteNodeinBST_test {

    @Test
    public void test1() {
        deleteNodeinBST test = new deleteNodeinBST();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);

        test.DeleteBSTNode(root,3);
//        PrettyPrintTree lcs = new PrettyPrintTree(Arrays.asList(80, 30, 90, 20,
//                100, 99, 40, 10, 25, 35, 50, 5, 15, 23, 28, 33, 38, 41, 55));
//        PrettyPrintTree.prettyPrintTree(lcs.root);
    }

}
