package leetcode.Tree;

import java.util.*;

/**
 * Created by freewheel on 2017/2/13.
 */
public class BinaryTreeLevelOrderTraversal2 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(17);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        new BinaryTreeLevelOrderTraversal2().levelOrderBottom(node1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}

/**
 * [1,2,null,3,null,4,null,5]
 *        1
 *      2    n
 *    3  n  4  n
 *  5
 *
 *
 * */