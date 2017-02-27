package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/26.
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 * 比如，给出下列数字三角形：
 * <p>
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * 从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
 */
public class TriangleMinPath {
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }

        int rows = triangle.length;
        if (rows == 1) {
            return triangle[0][0];
        } else {
            int[] dp = new int[rows];
            dp[0] = triangle[0][0];

            for (int currentRow = 1; currentRow < rows; currentRow++) {
                //关键点在这个for loop的循环方向，应该是从尾往头loop，否则会用到更新后的数据
                for (int index = currentRow; index >= 0; index--) {
                    if (index == 0) {
                        dp[index] = triangle[currentRow][index] + dp[index];
                    } else if (index == currentRow) {
                        dp[index] = triangle[currentRow][index] + dp[index - 1];
                    } else {
                        dp[index] = triangle[currentRow][index] + Math.min(dp[index - 1], dp[index]);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (int n : dp) {
                if (n < min) {
                    min = n;
                }
            }
            return min;
        }
    }
}
