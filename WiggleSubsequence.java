package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/8/16.
 */
public class WiggleSubsequence {
    //fail
    public int wiggleMaxLength2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        if (length == 1) return 1;
        if (length == 2) {
            if (nums[1] == nums[0])
                return 1;
            else
                return 2;
        }

        int left = 0;
        int right = 1;

        while (right < length && nums[right] == nums[left]) {
            left++;
            right++;
        }
        if (right == length) {
            if (nums[right - 1] == nums[left - 1]) {
                return 1;
            } else {
                return 2;
            }
        }

        int count = 2;
        boolean flag = (nums[right] - nums[left] > 0);
        left++;
        right++;
        while (right < length) {
            if (nums[right] == nums[left] || (nums[right] - nums[left] > 0) == flag) {
                right++;
            } else {
                count++;
                left++;
                right++;
                flag = !flag;
            }
        }

        return count;
    }


    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        boolean start = false;
        int length = nums.length;
        int[] diffs = new int[length];
        int[] results = new int[length];
        for (int i = 0; i < length - 1; i++) {
            diffs[i + 1] = nums[i + 1] - nums[i];
        }

        results[0] = 0;
        for (int i = 1; i < length; i++) {
            if (diffs[i] == 0) {
                results[i] = results[i - 1];
                diffs[i] = diffs[i - 1];
            } else if (start) {
                int plus = diffs[i] * diffs[i - 1] < 0 ? 1 : 0;
                results[i] = results[i - 1] + plus;
            }else {
                results[i] = 1;
                start = true;
            }
        }
        return results[length - 1] + 1;
    }

    public static void main(String[] args) {

        testWiggleSubsequence(new int[]{1, 7, 4, 9, 2, 5});
        testWiggleSubsequence(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
        testWiggleSubsequence(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        testWiggleSubsequence(new int[]{1, 1});
        testWiggleSubsequence(new int[]{1, 1, 1, 1, 1, 1, 1, 1});
        testWiggleSubsequence(new int[]{33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15});
    }

    private static void testWiggleSubsequence(int[] nums) {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        int count = wiggleSubsequence.wiggleMaxLength(nums);
        System.out.println(count);
    }
}
