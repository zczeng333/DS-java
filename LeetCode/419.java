class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int i_temp;
        int j_temp;
        for (int i = 0; i < board.length; i++) {//for each row
            for (int j = 0; j < board[0].length; j++) {//for each element
                if (board[i][j] == 'X') {
                    count++;
                    i_temp = i;
                    j_temp = j;
                    while (j_temp - 1 >= 0 && board[i_temp][j_temp - 1] == 'X') {    //left
                        board[i_temp][j_temp - 1] = '.';
                        j_temp = j_temp - 1;
                    }
                    if (j_temp != j) {
                        continue;
                    }
                    while (j_temp + 1 < board[0].length && board[i_temp][j_temp + 1] == 'X') {    //right
                        board[i_temp][j_temp + 1] = '.';
                        j_temp = j_temp + 1;
                    }
                    if (j_temp != j) {
                        continue;
                    }
                    while (i_temp - 1 >= 0 && board[i_temp - 1][j_temp] == 'X') {    //up
                        board[i_temp - 1][j_temp] = '.';
                        i_temp = i_temp - 1;
                    }
                    if (i_temp != i) {
                        continue;
                    }
                    while (i_temp + 1 < board.length && board[i_temp + 1][j_temp] == 'X') {    //up
                        board[i_temp + 1][j_temp] = '.';
                        i_temp = i_temp + 1;
                    }
                }
            }
        }
        return count;
    }
}