class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }
        int[][] count = new int[board.length][board[0].length];//count用于记录每个未知的细胞周围九宫格内的活细胞数
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    update(count, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (count[i][j] < 2) {
                        board[i][j] = 0;
                    } else if (count[i][j] > 3) {
                        board[i][j] = 0;
                    }
                } else if (count[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public void update(int[][] count, int i, int j) {//对board[i][j]九宫格内的计数进行更新
        if (i > 0) {
            count[i - 1][j]++;
            if (j > 0) {
                count[i - 1][j - 1]++;
            }
            if (j < count[0].length - 1) {
                count[i - 1][j + 1]++;
            }
        }
        if (i < count.length - 1) {
            count[i + 1][j]++;
            if (j > 0) {
                count[i + 1][j - 1]++;
            }
            if (j < count[0].length - 1) {
                count[i + 1][j + 1]++;
            }
        }
        if (j > 0) {
            count[i][j - 1]++;
        }
        if (j < count[0].length - 1) {
            count[i][j + 1]++;
        }
    }
}