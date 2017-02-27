package leetcode.Tree;

/**
 * Created by freewheel on 2017/2/23.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {

        int[] results = tryRob(root);
        return Math.max(results[0], results[1]);
    }


    private int[] tryRob(TreeNode node) {

        if (node == null) {
            return new int[]{0, 0};
        } else if (node.left == null && node.right == null) {
            return new int[]{node.val, 0};
        } else {
            int[] leftVals = tryRob(node.left);
            int[] rightVals = tryRob(node.right);

            int[] res = new int[2];
            res[0] = node.val + leftVals[1] + rightVals[1];
            res[1] = Math.max(leftVals[0], leftVals[1]) + Math.max(rightVals[0], rightVals[1]);

            return res;
        }

    }
}
