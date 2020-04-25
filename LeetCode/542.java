class Solution {
    int[][] dis;
    int[][] m;

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int i, j;
        dis = new int[row][col];
        for (i = 0; i < row; i++) {//初始化动态规划数组
            for (j = 0; j < col; j++) {
                dis[i][j] = row + col;
            }
        }
        m = matrix;
        for (i = 0; i < row; i++) {//从左上至右下进行dp
            for (j = 0; j < col; j++) {
                update(i, j);
            }
        }
        for (i = row - 1; i >= 0; i--) {//从右下至左上进行dp
            for (j = col - 1; j >= 0; j--) {
                update(i, j);
            }
        }
        return dis;
    }

    public void update(int i, int j) {//更新[i,j]位置的dis值
        if (m[i][j] == 0) {
            dis[i][j] = 0;
            return;
        }
        if (j != 0) {
            dis[i][j] = Math.min(dis[i][j], dis[i][j - 1] + 1);
        }//左边元素
        if (j != m[0].length - 1) {
            dis[i][j] = Math.min(dis[i][j], dis[i][j + 1] + 1);
        }//右边元素
        if (i != 0) {
            dis[i][j] = Math.min(dis[i][j], dis[i - 1][j] + 1);
        }//上边元素
        if (i != m.length - 1) {
            dis[i][j] = Math.min(dis[i][j], dis[i + 1][j] + 1);
        }//下边元素
    }
}