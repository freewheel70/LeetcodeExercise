package leetcode.DynamicProgramming;

import java.util.*;

/**
 * Created by freewheel on 2017/2/26.
 */
public class LongestSameNumbers {
    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5});
        test(new int[]{1, 2, 2, 4, 5});
        test(new int[]{1, 2, 2, 3, 4, 4, 5});
        test(new int[]{1, 2, 3, 4, 5, 5});
        test(new int[]{1, 1, 2, 3, 4, 5, 5});
    }

    private static void test(int[] nums) {
        LongestSameNumbers ls = new LongestSameNumbers();
        int[] ints = ls.longestSameNumbers(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("result: ");
        System.out.println(Arrays.toString(ints));
        System.out.println();
    }

    public int[] longestSameNumbers(int[] nums) {
        //112112334333

        if (nums == null || nums.length == 0) return new int[0];

        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = 1;

        int maxLen = 1;

        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            if (dp[i] > maxLen) maxLen = dp[i];
        }

        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLen) {
                resultSet.add(nums[i]);
            }
        }

        int[] results = new int[resultSet.size()];
        int index = 0;
        for (Integer ret : resultSet) {
            results[index++] = ret;
        }

        return results;
    }

}
