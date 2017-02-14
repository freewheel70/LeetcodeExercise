package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by freewheel on 2017/2/14.
 */
public class BinaryTreePaths {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;

        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
        } else {
            if (root.left != null) {
                traversePath(String.valueOf(root.val), root.left);
            }
            if (root.right != null) {
                traversePath(String.valueOf(root.val), root.right);
            }
        }

        return result;
    }

    private void traversePath(String s, TreeNode node) {
        String newS = s + "->" + node.val;
        if (node.left == null && node.right == null) {
            result.add(newS);
            return;
        } else {
            if (node.left != null) {
                traversePath(newS, node.left);
            }
            if (node.right != null) {
                traversePath(newS, node.right);
            }
        }

    }
}
