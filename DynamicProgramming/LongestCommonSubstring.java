package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/24.
 * iterative method
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        int ret = new LongestCommonSubstring().longestCommonSubstring("abcdgg", "abcdhh");
        System.out.println(ret);
    }

    public int longestCommonSubstring(String A, String B) {

        if (A == null || B == null) {
            return 0;
        }

        int lenA = A.length();
        int lenB = B.length();

        if (lenA == 0 || lenB == 0) {
            return 0;
        }

        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        int[][] dp = new int[lenA][lenB];
        //definition of dp[i][j]:
        // the length of common substring end with i-th char in A and j-th char in B
        // it is the status only associated with current chars

        int max = 0;

        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (charsA[i] == charsB[j]) ? 1 : 0;
                } else {
                    if (charsA[i] == charsB[j]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }



}
