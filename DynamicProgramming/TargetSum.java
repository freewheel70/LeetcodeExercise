package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/18.
 */
public class TargetSum {

    //method One: recursion
    //elegant but slow
    int[] nums;
    int S;
    int len;

    public int findTargetSumWays1(int[] nums, int S) {
        this.nums = nums;
        this.S = S;
        len = nums.length;


        return find(1, nums[0]) + find(1, -nums[0]);
    }

    private int find(int index, int currentS) {
        if (index == len) {
            return (currentS == S) ? 1 : 0;
        } else {
            int nextIndex = index + 1;
            int curNum = nums[index];
            if (curNum == 0) {
                return find(nextIndex, currentS) * 2;
            } else {
                return find(nextIndex, currentS - curNum) + find(nextIndex, currentS + curNum);
            }
        }
    }


    //method Two:
    public int findTargetSumWays2(int[] nums, int S) {
        //pluses - negatives = S
        //pluses + negatives = totalSum
        //pluses = (S + totalSum) / 2

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum < S) return 0;

        if (((S + totalSum) & 1) == 1) return 0;//odd

        int targetSum = (S + totalSum) >> 1;

        return findTargetSum(nums, targetSum);
    }

    private int findTargetSum(int[] nums, int targetSum) {
        int dp[] = new int[targetSum + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        //dp[i] stands for the ways to build a sum whose value is i

        for (int num : nums) {
            for (int i = targetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[targetSum];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 981};
        System.out.println(new TargetSum().findTargetSumWays2(nums, 1000000000));
    }

}
