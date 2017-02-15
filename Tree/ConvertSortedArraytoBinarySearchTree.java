package leetcode.Tree;

/**
 * Created by freewheel on 2017/2/11.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start < 0 || end > nums.length - 1 || start > end) return null;
        if (start == end) return new TreeNode(nums[start]);

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, end);

        return node;
    }



}
