package leetcode.Tree;

/**
 * Created by freewheel on 2017/2/13.
 */
public class PathSum3 {


    int counter;

    public int pathSum(TreeNode root, int sum) {
        traverse(root, sum);
        return counter;
    }

    private void traverse(TreeNode node, int sum) {

        if (node == null) return;

        check(node, sum);
        traverse(node.left, sum);
        traverse(node.right, sum);

    }

    private void check(TreeNode node, int sum) {
        if (node == null) return;
        if (node.val == sum) {
            counter++;
            check(node.left, 0);
        } else {
            check(node.left, sum - node.val);
            check(node.right, sum - node.val);
        }
    }
}
//[1,-2,-3,1,3,-2,null,-1]
/*
*        1
*    -2   -3
*   1 3  -2
* -1
* */
//-1