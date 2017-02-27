package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/26.
 */
public class LongestDecreasingSubstring {

    public static void main(String[] args) {
        LongestDecreasingSubstring lds = new LongestDecreasingSubstring();
        System.out.println(lds.longestDecreasingSubstring(new int[]{2,1,3,2,1,7,5,3,2,6}));
    }


    public int longestDecreasingSubstring(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        if (length == 1) {
            return 1;
        }

        int[] dp = new int[length];

        dp[0] = 1;
        int maxLen = 1;

        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }


        return maxLen;
    }
}
