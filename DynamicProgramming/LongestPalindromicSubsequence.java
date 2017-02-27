package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/24.
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
    }

    //Dp recursively
    public int longestPalindromeSubseq3(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[length][length];


        return find(dp, chars, 0, length - 1);
    }

    private int find(int[][] dp, char[] chars, int i, int j) {
        int val = dp[i][j];
        if (val != 0)
            return val;

        if (i == j) {
            val = 1;
        } else {

            if (chars[i] == chars[j]) {
                if (i + 1 == j) {
                    val = 2;
                } else {
                    val = 2 + find(dp, chars, i + 1, j - 1);
                }
            } else {
                val = Math.max(find(dp, chars, i + 1, j), find(dp, chars, i, j - 1));
            }

        }
        dp[i][j] = val;
        return val;
    }

    //reverse the string so that the problem because find the longest subsequence of two strings
    public int longestPalindromeSubseq(String s) {

        StringBuilder builder = new StringBuilder(s);
        String reverseS = builder.reverse().toString();

        return new LongestCommonSequence().longestCommonSubsequence(s, reverseS);
    }


    //directly use DP iteratively
    public int longestPalindromeSubseq2(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] chars = s.toCharArray();

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c = chars[i];
            for (int j = i + 1; j < len; j++) {
                if (c == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
