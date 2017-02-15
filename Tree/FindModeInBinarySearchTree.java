package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by freewheel on 2017/2/12.
 */
public class FindModeInBinarySearchTree {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        trace(root);

        List<Integer> results = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Integer integer : map.values()) {
            if (integer > max) max = integer;
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == max) results.add(key);
        }

        int[] retArray = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            retArray[i] = results.get(i);
        }

        return retArray;
    }

    private void trace(TreeNode node) {
        if (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);

            trace(node.left);
            trace(node.right);
        }
    }





    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    //using "global" variables to store the possible mode(s) and their amount
    //traverse the tree
    //compare node value with the mode, and update the amount
    //using a maxCount to store the max amount
    //traverse the tree again
    //fill in the modes array if the amount equal to maxCount
    public int[] findMode2(TreeNode root) {
        findOutMaxCount(root);

        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;

        fillResults(root);

        return modes;
    }


    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            modeCount++;
        }
    }

    private void findOutMaxCount(TreeNode root) {
        if (root == null) return;
        findOutMaxCount(root.left);
        handleValue(root.val);
        findOutMaxCount(root.right);
    }

    private void fillResults(TreeNode root) {
        if (root == null) return;
        fillResults(root.left);
        checkValue(root.val);
        fillResults(root.right);
    }

    private void checkValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;

        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            modes[modeCount] = currVal;
            modeCount++;
        }
    }
}
