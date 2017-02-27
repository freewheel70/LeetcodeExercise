package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/24.
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }


    //Not DP but works greatly
    //tails is an array storing the smallest tail of all increasing subsequences
    // with length i+1 in tails[i].
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    //DP O(n^2)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;

        if (length == 1) return 1;

        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 1; i < length; i++) {
            int current = nums[i];
            for (int j = 0; j < i; j++) {
                if (current > nums[j]) {
                    int temp = dp[j] + 1;
                    if (temp > dp[i]) dp[i] = temp;
                }
            }
            if (dp[i] > max) max = dp[i];
        }

        return max;
    }


}
