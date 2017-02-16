package leetcode.Tree;

import java.util.*;

/**
 * Created by freewheel on 2017/2/16.
 */
public class MostFrequentSubtreeSum {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(-3);

        node1.left = node2;
        node1.right = node3;

        System.out.println(Arrays.toString(new MostFrequentSubtreeSum().findFrequentTreeSum(node1)));
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        int mysum = findSum(root);

        int max = 0;
        for (Integer val : map.values()) {
            if (val > max) max = val;
        }

        List<Integer> sumsList = new ArrayList<>();
        for (Integer sum : map.keySet()) {
            if (map.get(sum) == max) sumsList.add(sum);
        }

        int[] result = new int[sumsList.size()];
        for (int i = 0; i < sumsList.size(); i++) {
            result[i] = sumsList.get(i);
        }

        return result;
    }

    private int findSum(TreeNode node) {
        int mysum = node.val;
        if (node.left == null && node.right == null) {
            //a leave
        } else {

            if (node.left != null)
                mysum += findSum(node.left);

            if (node.right != null)
                mysum += findSum(node.right);
        }
        map.put(mysum, map.getOrDefault(mysum, 0) + 1);

        return mysum;
    }
}
