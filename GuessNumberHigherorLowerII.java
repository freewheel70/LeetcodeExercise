package leetcode;

/**
 * Created by Administrator on 2016/8/18.
 */
public class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        // all intervals are inclusive
        // uninitialized cells are assured to be zero
        // the zero column and row will be uninitialized
        // the illegal cells will also be uninitialized
        // add 1 to the length just to make the index the same as numbers used
        int[][] costs = new int[n + 1][n + 1]; // costs[i][j] means the min cost in the worst case for numbers (i...j)

        // iterate the lengths of the intervals since the calculations of longer intervals rely on shorter ones
        for (int length = 2; length <= n; length++) {
            // iterate all the intervals with length length, the start of which is i. Hence the interval will be [i, i + (length - 1)]
            for (int i = 1; i <= n - (length - 1); i++) {
                costs[i][i + (length - 1)] = Integer.MAX_VALUE;
                // iterate all the first guesses g
                for (int g = i; g <= i + (length - 1); g++) {
                    int costForThisGuess;
                    // since if g is the last integer, g + 1 does not exist, we have to separate this case
                    // cost for [i, i + (length - 1)]: g (first guess) + max{the cost of left part [i, g - 1], the cost of right part [g + 1, i + (length - 1)]}
                    if (g == n) {
                        costForThisGuess = costs[i][g - 1] + g;
                    } else {
                        costForThisGuess = g + Math.max(costs[i][g - 1], costs[g + 1][i + (length - 1)]);
                    }
                    costs[i][i + (length - 1)] = Math.min(costs[i][i + (length - 1)], costForThisGuess); // keep track of the min cost among all first guesses
                }
            }
        }
        return costs[1][n];
    }

    public int getMoneyAmount2(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int len=1;len<n;len++){
            for(int i=1;i+len<=n;i++){
                int j=i+len;
                int min = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int tmp = k+Math.max(dp[i][k-1],dp[k+1][j]);
                    min = Math.min(min,tmp);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}
