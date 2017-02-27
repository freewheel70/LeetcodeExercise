package leetcode.Tree;

/**
 * Created by freewheel on 2017/2/23.
 */
public class KthSmallestElementinABST {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left);
        if (leftCount == k - 1) {
            return root.val;
        } else if (leftCount > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftCount - 1);
        }
    }

    private int count(TreeNode node) {
        if (node == null) return 0;

        int mycount = 1;
        if (node.left != null) {
            mycount += count(node.left);
        }
        if (node.right != null) {
            mycount += count(node.right);
        }

        return mycount;
    }
}
