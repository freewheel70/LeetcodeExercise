package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/19.
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        //invalid if odd
        if ((sum & 1) == 1) return false;

        int partitionedSum = sum >> 1;
        //dp[i] :

        boolean[] dp = new boolean[partitionedSum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int targetSum = partitionedSum; targetSum > 0; targetSum--) {
                if (targetSum >= num) {
                    dp[targetSum] = dp[targetSum] || dp[targetSum-num];
                }
            }
        }

        return dp[partitionedSum];

    }
}
