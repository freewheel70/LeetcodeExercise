package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/2.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean validBlock = isValidBlock(board[i]);
            if (!validBlock) return false;
        }
        System.out.println("------line end--------");

        char[] column = new char[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                column[j] = board[j][i];
            }
            boolean validBlock = isValidBlock(column);
            if (!validBlock) return false;
        }

        System.out.println("------column end--------");

        char[] cell = new char[9];
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                cell[0] = board[i][j];
                cell[1] = board[i + 1][j];
                cell[2] = board[i + 2][j];

                cell[3] = board[i][j + 1];
                cell[4] = board[i + 1][j + 1];
                cell[5] = board[i + 2][j + 1];

                cell[6] = board[i][j + 2];
                cell[7] = board[i + 1][j + 2];
                cell[8] = board[i + 2][j + 2];

                boolean validBlock = isValidBlock(cell);
                if (!validBlock) return false;
            }

        }
        System.out.println("------cell end--------");

        return true;
    }

    private boolean isValidBlock(char[] chars) {
        System.out.println("isValidBlock " + Arrays.toString(chars));
        boolean[] flags = new boolean[9];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '.') {
                int index = charToIndex(chars[i]);
                if (flags[index]) {
                    return false;
                } else {
                    flags[index] = true;
                }
            }
        }
        return true;
    }

    private int charToIndex(char aChar) {
        return aChar - '1';
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '4', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '7', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '3', '.', '.', '.', '6', '.'},
                {'.', '.', '.', '.', '.', '6', '.', '9', '.'},
                {'.', '.', '.', '.', '1', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '8', '.', '.', '.', '.', '.'}
        };
        test(board);
    }

    private static void test(char[][] board) {
        ValidSudoku sudoku = new ValidSudoku();
        System.out.println(sudoku.isValidSudoku(board));
    }
}
