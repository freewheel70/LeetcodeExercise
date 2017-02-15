package leetcode.Tree;

/**
 * Created by freewheel on 2017/2/15.
 */
public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        root.left = node;

        System.out.println(new MinimumDepthofBinaryTree().minDepth(node));

    }

    int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        find(root, 0);

        return min;
    }

    private void find(TreeNode node, int depth) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            depth++;
            if (depth < min) min = depth;
        } else {
            find(node.left, depth + 1);
            find(node.right, depth + 1);
        }
    }
}
