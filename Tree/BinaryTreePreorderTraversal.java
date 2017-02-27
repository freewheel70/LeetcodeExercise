package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by freewheel on 2017/2/21.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> results = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;
        while (true) {
            if (node.right != null)
                stack.push(node.right);

            results.add(node.val);

            if (node.left != null)
                node = node.left;
            else {
                if (!stack.isEmpty()) {
                    node = stack.pop();
                } else {
                    break;
                }
            }
        }

        return results;

    }
}
