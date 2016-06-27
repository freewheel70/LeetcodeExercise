package leetcode;

/**
 * Created by Administrator on 2016/6/27.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {


        int depth = getDepth(root);
        return (depth != -1);
    }

    private int getDepth(TreeNode node) {

        int depth = 0;

        if (node != null) {
            depth++;
            int depthLeft = getDepth(node.left);
            if (depthLeft == -1) {
                return -1;
            }
            int depthRight = getDepth(node.right);
            if (depthRight == -1) {
                return -1;
            }
//            System.out.println("depthLeft " + depthLeft + " ;depthRight " + depthRight);
            int diff = depthLeft - depthRight;
            if (diff > 1 || diff < -1) {
                return -1;
            }
            depth += (depthLeft > depthRight) ? depthLeft : depthRight;
        }

        return depth;
    }

    /**
     * better not use Exception if you wanna performance
     */
    static class UnBalancedException extends Exception {

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        System.out.println(binaryTree.isBalanced(root));
    }

}
