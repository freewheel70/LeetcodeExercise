package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/25.
 */
public class DistinctPathOfGrid {

    public static void main(String[] args) {
        System.out.println(new DistinctPathOfGrid().findDistinctPaths(3,3));
    }

    public int findDistinctPaths(int x, int y) {
        int[][] paths = new int[x][y];
        for (int i = 0; i < x; i++) {
            Arrays.fill(paths[i], -1);
        }

        Arrays.fill(paths[0], 1);
        for (int i = 0; i < x; i++) {
            paths[i][0] = 1;
        }

        return findPath(paths, x-1, y-1);
    }

    private int findPath(int[][] paths, int m, int n) {
        if (m == 0 || n == 0) return paths[m][n];
        if (paths[m][n] != -1) return paths[m][n];
        int val = findPath(paths, m - 1, n) + findPath(paths, m, n - 1);
        paths[m][n] = val;
        return val;
    }
}
