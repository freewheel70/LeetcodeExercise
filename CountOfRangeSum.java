package leetcode;

/**
 * Created by freewheel on 2017/2/8.
 */
public class CountOfRangeSum {
    public static void main(String[] args) {

    }

    //if neighbors' value is in range, sum must be in range
    //range considered as single one
    //
    // wide to narrow ?
    // range = start -- end
    //
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;

        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);

        int j = mid, k = mid, t = mid, r = 0;
        long[] cache = new long[end - start];
        for (int i = start; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower)
                k++;
            while (j < end && sums[j] - sums[i] <= upper)
                j++;

            while (t < end && sums[t] < sums[i])
                cache[r++] = sums[t++]; //start merging

            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, r);
        return count;
    }

//    private class TreeNode {
//        long val = 0;
//        int count = 1;
//        int leftSize = 0;
//        int rightSize = 0;
//        TreeNode left = null;
//        TreeNode right = null;
//
//        public TreeNode(long v) {
//            this.val = v;
//            this.count = 1;
//            this.leftSize = 0;
//            this.rightSize = 0;
//        }
//    }
//
//    private TreeNode insert(TreeNode root, long val) {
//        if (root == null) {
//            return new TreeNode(val);
//        } else if (root.val == val) {
//            root.count++;
//        } else if (val < root.val) {
//            root.leftSize++;
//            root.left = insert(root.left, val);
//        } else if (val > root.val) {
//            root.rightSize++;
//            root.right = insert(root.right, val);
//        }
//        return root;
//    }
//
//    private int countSmaller(TreeNode root, long val) {
//        if (root == null) {
//            return 0;
//        } else if (root.val == val) {
//            return root.leftSize;
//        } else if (root.val > val) {
//            return countSmaller(root.left, val);
//        } else {
//            return root.leftSize + root.count + countSmaller(root.right, val);
//        }
//    }
//
//    private int countLarger(TreeNode root, long val) {
//        if (root == null) {
//            return 0;
//        } else if (root.val == val) {
//            return root.rightSize;
//        } else if (root.val < val) {
//            return countLarger(root.right, val);
//        } else {
//            return countLarger(root.left, val) + root.count + root.rightSize;
//        }
//    }
//
//    private int rangeSize(TreeNode root, long lower, long upper) {
//        int total = root.count + root.leftSize + root.rightSize;
//        int smaller = countSmaller(root, lower);    // Exclude everything smaller than lower
//        int larger = countLarger(root, upper);      // Exclude everything larger than upper
//        return total - smaller - larger;
//    }
//
//    public int countRangeSum(int[] nums, int lower, int upper) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        long[] sums = new long[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            sums[i + 1] = sums[i] + nums[i];
//        }
//        TreeNode root = new TreeNode(sums[0]);
//        int output = 0;
//        for (int i = 1; i < sums.length; i++) {
//            output += rangeSize(root, sums[i] - upper, sums[i] - lower);
//            insert(root, sums[i]);
//        }
//        return output;
//    }

}
