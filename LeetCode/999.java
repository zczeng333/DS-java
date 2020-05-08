class Solution {
    public int numRookCaptures(char[][] board) {
        int x = 0, y = 0, count = 0;
        for (int i = 0; i < board.length; i++) {//寻找车的位置
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'p') {
                count++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = x + 1; i < board.length; i++) {
            if (board[i][y] == 'p') {
                count++;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'p') {
                count++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        for (int i = y + 1; i < board[0].length; i++) {
            if (board[x][i] == 'p') {
                count++;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        return count;
    }
}