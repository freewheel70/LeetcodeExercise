package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/25.
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(1));
    }

    public int numTrees(int n) {
        //select the root
        //different root determine different tree
        //select left child and right child by recurse
        if (n <= 0) return 0;


        int[][] dp = new int[n][n];
        return find(dp, 0, n - 1);
    }

    private int find(int[][] dp, int start, int end) {
        if (start > end) return 1;
        if (dp[start][end] != 0) return dp[start][end];
        int val = 0;
        if (start == end) {
            val = 1;
        } else {
            if (start + 1 == end) {
                val = 2;
            } else {
                for (int i = start; i <= end; i++) {
                    //select i as root
                    val += (find(dp, start, i - 1) * find(dp, i + 1, end));
                }
            }

        }
        dp[start][end] = val;
        return val;
    }
}
