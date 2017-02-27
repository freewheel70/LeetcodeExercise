package leetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by freewheel on 2017/2/24.
 */
public class OnesAndZeroes {


    //dp不仅可以用在被操作的目标上，比如这里的 strs ， 也可以反过来利用条件， 比如这里的 numOf0 numOf1
    public int findMaxForm(String[] strs, int numOf0, int numOf1) {
        if (strs == null || strs.length == 0) return 0;

        int length = strs.length;
        int[][] dp = new int[numOf0 + 1][numOf1 + 1];

        for (int i = 0; i < length; i++) {
            int[] data = fillData(strs[i]);

            //从大到小遍历，才能使新一轮的数据可以利用到上一轮的数据
            for (int j = numOf0; j >= data[0]; j--) {
                for (int k = numOf1; k >= data[1]; k--) {
                    dp[j][k] = Math.max(dp[j - data[0]][k - data[1]] + 1, dp[j][k]);
                }
            }

        }

        return dp[numOf0][numOf1];
    }


    private int[] fillData(String str) {

        int[] data = new int[2];
        int numOf0 = 0;
        int numOf1 = 0;
        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '0')
                numOf0++;
            else
                numOf1++;
        }
        data[0] = numOf0;
        data[1] = numOf1;

        return data;
    }
}
