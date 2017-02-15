package leetcode.Tree;

/**
 * Created by freewheel on 2017/2/14.
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            } else {
                return compare(node1.left, node2.right) && compare(node1.right, node2.left);

            }
        } else {
            return false;
        }
    }
}
