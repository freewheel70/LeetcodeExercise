package leetcode.Tree;

/**
 * Created by freewheel on 2017/2/10.
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {

    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null) {
            sum += sumOfLeftLeaves(root.left, true);
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right, false);
        }
        return sum;
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        int sum = 0;
        if (root.left == null && root.right == null) {
            if (isLeft) return root.val;
        } else {
            if (root.left != null) {
                sum += sumOfLeftLeaves(root.left, true);
            }
            if (root.right != null) {
                sum += sumOfLeftLeaves(root.right, false);
            }
        }
        return sum;
    }


}
