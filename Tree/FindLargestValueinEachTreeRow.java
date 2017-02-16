package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by freewheel on 2017/2/16.
 */
public class FindLargestValueinEachTreeRow {


    public List<Integer> largestValues(TreeNode root) {
        if (root==null) return Collections.emptyList();
        List<Integer> mlargestValues = new ArrayList<>();
        fill(mlargestValues,root,0);
        return mlargestValues;
    }

    private void fill(List<Integer> mlargestValues, TreeNode node, int level) {
        if (level == mlargestValues.size()) {
            mlargestValues.add(Integer.MIN_VALUE);
        }
        if (node.left != null) fill(mlargestValues, node.left, level + 1);
        if (node.right != null) fill(mlargestValues, node.right, level + 1);

        mlargestValues.set(level, Math.max(mlargestValues.get(level), node.val));
    }
}
