package leetcode;

/**
 * Created by freewheel on 2017/2/12.
 */
public class GameOfLife {

    int rows;
    int columns;
    int[][] board;

    public void gameOfLife(int[][] board) {
        rows = board.length;
        columns = board[0].length;
        this.board = board;

        int[][] newCells = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean isAlive = checkAlive(board, i, j);
                newCells[i][j] = isAlive ? 1 : 0;
            }
        }

        copyCells(board, newCells);
    }

    private void copyCells(int[][] newCells, int[][] cells) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newCells[i][j] = cells[i][j];
            }
        }
    }

    private boolean checkAlive(int[][] board, int i, int j) {
        int aliveNum = 0;
        aliveNum += getCellByPos(board, i - 1, j - 1);
        aliveNum += getCellByPos(board, i - 1, j);
        aliveNum += getCellByPos(board, i - 1, j + 1);
        aliveNum += getCellByPos(board, i, j - 1);
        aliveNum += getCellByPos(board, i, j + 1);
        aliveNum += getCellByPos(board, i + 1, j - 1);
        aliveNum += getCellByPos(board, i + 1, j);
        aliveNum += getCellByPos(board, i + 1, j + 1);

        boolean isCurrentCellAlive = (board[i][j] == 1);
        if (isCurrentCellAlive) {
            if (aliveNum == 2 || aliveNum == 3) {
                return true;//stay alive
            } else {
                return false;//too lonely or crowded
            }
        } else {
            if (aliveNum == 3) {
                return true;//reborn
            } else {
                return false;//stay dead
            }
        }
    }

    private int getCellByPos(int[][] board, int i, int j) {
        if (i >= 0 && i < rows && j >= 0 && j < columns) {
            return board[i][j];
        }
        return 0;
    }


}
