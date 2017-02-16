package leetcode.Others;

/**
 * Created by freewheel on 2017/2/16.
 */
public class BattleshipsInaBoard {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;
        int[] mask = new int[board[0].length];
        int counter = 0;


        //check right-bottom corner -> determine it is a batteship
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //battleship -> surround by * or boundary
                if (board[i][j] == 'X') {

                    //check right
                    if (j + 1 < board[0].length && board[i][j + 1] == 'X') {
                        continue;
                    }

                    //check bottom
                    if (i + 1 < board.length && board[i + 1][j] == 'X') {
                        continue;
                    }

                    counter++;
                }
            }
        }

        return counter;
    }
}
