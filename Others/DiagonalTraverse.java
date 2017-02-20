package leetcode.Others;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/18.
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        System.out.println(Arrays.toString(new DiagonalTraverse().findDiagonalOrder(matrix)));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] results = new int[rows * columns];

        if (rows == 1) {
            for (int i = 0; i < columns; i++) {
                results[i] = matrix[0][i];
            }
            return results;
        }

        if (columns == 1) {
            for (int i = 0; i < rows; i++) {
                results[i] = matrix[i][0];
            }
            return results;
        }

        int row = 0;
        int col = 0;

        int index = 0;
        results[index] = matrix[row][col];

        index++;
        col++;
        boolean downwards = true;

        while (true) {
            results[index++] = matrix[row][col];

            if (row == rows - 1 && col == columns - 1) break;

            if (downwards) {
                if (col == 0 && row != rows - 1) {//touch the left boundary
                    downwards = false;
                    row++;
                } else if (row == rows - 1) {//touch the bottom
                    downwards = false;
                    col++;
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 && col != columns - 1) {
                    downwards = true;
                    col++;
                } else if (col == columns - 1) {
                    downwards = true;
                    row++;
                } else {
                    row--;
                    col++;
                }
            }
        }

        return results;
    }
}
