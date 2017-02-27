package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/25.
 * recursive methods
 * faster
 */
public class LongestCommonSubstring2 {

    int maxLen = 0;

    public int longestCommonSubstring(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return 0;
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                find(dp, i, j, chars1, chars2);
            }
        }

        return maxLen;
    }


    private int find(int[][] dp, int index1, int index2, char[] chars1, char[] chars2) {

        if (dp[index1][index2] != -1) return dp[index1][index2];

        if (index1 == 0 || index2 == 0) {
            if (chars1[index1] == chars2[index2]) {
                dp[index1][index2] = 1;
            } else {
                dp[index1][index2] = 0;
            }
        } else {
            if (chars1[index1] == chars2[index2]) {
                dp[index1][index2] = 1 + find(dp, index1 - 1, index2 - 1, chars1, chars2);
            } else {
                dp[index1][index2] = 0;
            }
        }

        if (dp[index1][index2] > maxLen) maxLen = dp[index1][index2];
        return dp[index1][index2];

    }
}
