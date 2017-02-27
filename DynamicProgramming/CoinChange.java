package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/25.
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
    }

    //key points:
    //the coins may not be sorted
    //should handle the unsolvable case e.g [2,3] 1
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;


        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            boolean found = false;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {//make sure the sub-problem is solved
                    found = true;
                    if (dp[i - coin] + 1 < min) min = dp[i - coin] + 1;
                }

            }
            if (found) dp[i] = min;
        }

        return dp[amount];
    }
}
