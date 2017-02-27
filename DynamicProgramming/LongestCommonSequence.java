package leetcode.DynamicProgramming;

import java.util.*;

/**
 * Created by freewheel on 2017/2/25.
 */
public class LongestCommonSequence {

    public static void main(String[] args) {
        LongestCommonSequence lcs = new LongestCommonSequence();
//        lcs.longestCommonSubsequence("abccdefggghijk", "cdopyehfgahddisjok");
        System.out.println(lcs.longestCommonSubsequence("atebfycgudih", "eaqfbwgczhdv"));
    }

    public int longestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[][] dp = new int[len1 + 1][len2 + 1];

        //dp should use extra row and column inorder to handle cases "abccdefggghijk","cdopyehfgahddisjok"
        //the first chars problem

        //definition of dp[i][j]:
        // the max length of common subsequence before(or equal) i-1 and j-1
        //it is a status associated with all precious cases

//        int max = 0;
// no need to introduce a max variable because the dp[i][j] already stands for the max length

        for (int i = 1; i <= len1; i++) {
            char c1 = chars1[i-1];
            for (int j = 1; j <= len2; j++) {
                char c2 = chars2[j-1];

                int lastMax = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (c1 == c2) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], lastMax);
                } else {
                    dp[i][j] = lastMax;
                }

            }
        }

        int maxLen = dp[len1][len2];


        System.out.println("\nPrint All LCS: ");
        printAllLCS(maxLen, chars1, chars2, dp);
        System.out.println(lcsList);

        return maxLen;
    }

    Set<String> lcsList = new HashSet<>();

    private void printAllLCS(int maxLen, final char[] chars1, final char[] chars2, final int[][] dp) {
        char[] lcs = new char[maxLen];
        printLCS(chars1, chars2, dp, lcs, maxLen - 1, chars1.length, chars2.length);
    }

    private void printLCS(final char[] chars1, final char[] chars2, final int[][] dp, char[] lcs, int index, int i, int j) {
        if (index < 0) {
            lcsList.add(new String(lcs));
            return;
        }

        if (chars1[i-1] == chars2[j-1]) {
            lcs[index] = chars1[i-1];
            printLCS(chars1, chars2, dp, lcs, index - 1, i - 1, j - 1);
        }

        if (i - 1 >= 0 && dp[i - 1][j] == dp[i][j]) {
            printLCS(chars1, chars2, dp, lcs, index, i - 1, j);
        }

        if (j - 1 >= 0 && dp[i][j - 1] == dp[i][j]) {
            printLCS(chars1, chars2, dp, lcs, index, i, j - 1);
        }

    }
}
