package leetcode;

/**
 * Created by freewheel on 2017/2/10.
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }


    //Method using math knowledge
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int column = grid[0].length;

        int numberOfLand = 0;
        int borders = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {


                if (grid[i][j] == 1) {
                    borders += getBorders(grid, rows, column, i, j);
                    numberOfLand++;
                }
            }
        }

        int perimeter = (numberOfLand * 4) - (borders);

        return perimeter;
    }

    private int getBorders(int[][] grid, int rows, int column, int i, int j) {

        int borders = 0;

        if (i - 1 >= 0) {
            borders += grid[i - 1][j];
        }
        if (i + 1 < rows) {
            borders += grid[i + 1][j];
        }
        if (j - 1 >= 0) {
            borders += grid[i][j - 1];
        }
        if (j + 1 < column) {
            borders += grid[i][j + 1];
        }

        return borders;
    }
}
