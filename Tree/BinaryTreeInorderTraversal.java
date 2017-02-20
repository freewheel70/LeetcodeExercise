package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by freewheel on 2017/2/20.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> results = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;

        //first, reach the leftmost leaf,and push every node , print the left most leaf
        //pop a  node and print it
        //goto its right leaf , repeat
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            results.add(node.val);//every time a node pop out , print it immediately and go to right leaf
            node = node.right;
        }

        return results;
    }
}
