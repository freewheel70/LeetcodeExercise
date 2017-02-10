package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/10.
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }


    public int findMaxConsecutiveOnes1(int[] nums) {
        if (nums.length == 0) return 0;
        int dp[] = new int[nums.length];

        dp[0] = (nums[0] == 1) ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = (nums[i] == 1) ? (dp[i - 1] + 1) : 0;
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) max = dp[i];
        }

        return max;
    }

    //without extra space, but slower
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;

        int currentMax, max;
        max = currentMax = (nums[0] == 1) ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            currentMax = (nums[i] == 1) ? (currentMax + 1) : 0;
            max = Math.max(max, currentMax);
        }

        return max;
    }
}
