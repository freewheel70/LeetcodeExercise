package leetcode.Tree;


import org.jetbrains.annotations.NotNull;

/**
 * Created by freewheel on 2017/2/16.
 */
public class FindBottomLeftTreeValue {

    public static void main(String[] args) {

    }

    int deepest = 0;
    boolean found = false;
    int bottomLeftValue = 0;

    public int findBottomLeftValue(TreeNode root) {
        findDeepest(root, 0);
        findValue(root, 0);
        return bottomLeftValue;
    }

    private void findDeepest(@NotNull TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            deepest = Math.max(deepest, depth + 1);
        }

        if (node.left != null) {
            findDeepest(node.left, depth + 1);
        }

        if (node.right != null) {
            findDeepest(node.right, depth + 1);
        }
    }

    private void findValue(@NotNull TreeNode node, int depth) {
        if (found) return;

        if (depth + 1 == deepest) {
            found = true;
            bottomLeftValue = node.val;
        } else {
            if (node.left != null) findValue(node.left, depth + 1);

            if (node.right != null) findValue(node.right, depth + 1);
        }
    }

}
