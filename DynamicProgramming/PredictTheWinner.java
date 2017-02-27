package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/21.
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {

        //in even numbers, always win by choosing v1 v3 v5 ... v(n-1) the odd pos or v2 v4 ... v(n) the even pos
        int len = nums.length;
        if ((len & 1) == 0) return true;


        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int maxScoreOfplayer1 = dphelper(nums, dp, 0, len - 1);

        return maxScoreOfplayer1 >= (totalSum - maxScoreOfplayer1);
    }

    private int dphelper(int[] nums, int[][] dp, int i, int j) {
        if (i == j) return dp[i][j];
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (j - i == 1) {
            dp[i][j] = Math.max(nums[i], nums[j]);
            return dp[i][j];
        }

        int possible1 = Math.min(dphelper(nums, dp, i + 1, j - 1), dphelper(nums, dp, i + 2, j)) + nums[i];

        int possible2 = Math.min(dphelper(nums, dp, i, j - 2), dphelper(nums, dp, i + 1, j - 1)) + nums[j];

        dp[i][j] = Math.max(possible1, possible2);

        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(new PredictTheWinner().PredictTheWinner(nums));
    }
}
