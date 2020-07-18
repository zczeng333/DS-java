//Solution 1: 递归，超时(exponential time complexity)
class Solution {
    public double knightProbability(int N, int K, int r, int c) {//返回在棋盘上的概率
        if (K == 0) {
            return 1;
        }
        double count = 0;//count计算其在棋盘上的概率
        if (r + 2 < N && c + 1 < N) {
            count = count + 1.0 / 8 * knightProbability(N, K - 1, r + 2, c + 1);
        }//右上移动仍在范围内
        if (r - 2 >= 0 && c + 1 < N) {
            count = count + 1.0 / 8 * knightProbability(N, K - 1, r - 2, c + 1);
        }//左上移动仍在范围内
        if (r + 2 < N && c - 1 >= 0) {
            count = count + 1.0 / 8 * knightProbability(N, K - 1, r + 2, c - 1);
        }//右下移动仍在范围内
        if (r - 2 >= 0 && c - 1 >= 0) {
            count = count + 1.0 / 8 * knightProbability(N, K - 1, r - 2, c - 1);
        }//左下移动仍在范围内
        if (c + 2 < N && r + 1 < N) {
            count = count + 1.0 / 8 * knightProbability(N, K - 1, r + 1, c + 2);
        }//上右移动仍在范围内
        if (c - 2 >= 0 && r + 1 < N) {
            count = count + 1.0 / 8 * knightProbability(N, K - 1, r + 1, c - 2);
        }//下右移动仍在范围内
        if (c + 2 < N && r - 1 >= 0) {
            count = count + 1.0 / 8 * knightProbability(N, K - 1, r - 1, c + 2);
        }//上左移动仍在范围内
        if (c - 2 >= 0 && r - 1 >= 0) {
            count = count + 1.0 / 8 * knightProbability(N, K - 1, r - 1, c - 2);
        }//下左移动仍在范围内
        return count;
    }
}

//Solution 2: 动态规划
class Solution {
    public double knightProbability(int N, int K, int r, int c) {//返回在棋盘上的概率
        if (K == 0) {
            return 1;
        }
        double[][][] dp = new double[N][N][K];//dp[i][j][k]表示执行第k+1个step时，马在棋盘上的概率
        double count;
        for (int i = 0; i < N; i++) {//设定dp矩阵中dp[i][j][N-1]的初始值（最后一步的概率）
            for (int j = 0; j < N; j++) {
                count = 0;
                if (i + 2 < N && j + 1 < N) {
                    count = count + 1.0 / 8;
                }//右上移动仍在范围内
                if (i - 2 >= 0 && j + 1 < N) {
                    count = count + 1.0 / 8;
                }//左上移动仍在范围内
                if (i + 2 < N && j - 1 >= 0) {
                    count = count + 1.0 / 8;
                }//右下移动仍在范围内
                if (i - 2 >= 0 && j - 1 >= 0) {
                    count = count + 1.0 / 8;
                }//左下移动仍在范围内
                if (j + 2 < N && i + 1 < N) {
                    count = count + 1.0 / 8;
                }//上右移动仍在范围内
                if (j - 2 >= 0 && i + 1 < N) {
                    count = count + 1.0 / 8;
                }//下右移动仍在范围内
                if (j + 2 < N && i - 1 >= 0) {
                    count = count + 1.0 / 8;
                }//上左移动仍在范围内
                if (j - 2 >= 0 && i - 1 >= 0) {
                    count = count + 1.0 / 8;
                }//下左移动仍在范围内
                dp[i][j][K - 1] = count;
            }
        }
        for (int k = K - 2; k >= 0; k--) {//遍历所有step
            for (int i = 0; i < N; i++) {//遍历当前step下所有节点
                for (int j = 0; j < N; j++) {
                    count = 0;
                    if (i + 2 < N && j + 1 < N) {
                        count = count + 1.0 / 8 * dp[i + 2][j + 1][k + 1];
                    }//右上移动仍在范围内
                    if (i - 2 >= 0 && j + 1 < N) {
                        count = count + 1.0 / 8 * dp[i - 2][j + 1][k + 1];
                    }//左上移动仍在范围内
                    if (i + 2 < N && j - 1 >= 0) {
                        count = count + 1.0 / 8 * dp[i + 2][j - 1][k + 1];
                    }//右下移动仍在范围内
                    if (i - 2 >= 0 && j - 1 >= 0) {
                        count = count + 1.0 / 8 * dp[i - 2][j - 1][k + 1];
                    }//左下移动仍在范围内
                    if (j + 2 < N && i + 1 < N) {
                        count = count + 1.0 / 8 * dp[i + 1][j + 2][k + 1];
                    }//上右移动仍在范围内
                    if (j - 2 >= 0 && i + 1 < N) {
                        count = count + 1.0 / 8 * dp[i + 1][j - 2][k + 1];
                    }//下右移动仍在范围内
                    if (j + 2 < N && i - 1 >= 0) {
                        count = count + 1.0 / 8 * dp[i - 1][j + 2][k + 1];
                    }//上左移动仍在范围内
                    if (j - 2 >= 0 && i - 1 >= 0) {
                        count = count + 1.0 / 8 * dp[i - 1][j - 2][k + 1];
                    }//下左移动仍在范围内
                    dp[i][j][k] = count;
                }
            }
        }
        return dp[r][c][0];
    }
}