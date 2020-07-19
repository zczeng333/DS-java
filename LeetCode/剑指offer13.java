class Solution {
    public int[][] record;//record记录位置是否被遍历过

    public int movingCount(int m, int n, int k) {
        record = new int[m][n];
        if (k == 0) {
            return 1;
        }
        record[0][0] = -1;
        return 1 + dfs(0, 0, k);//记录能遍历到的位置数
    }

    public int dfs(int x, int y, int k) {
        int count = 0;
        if (x > 0 && record[x - 1][y] == 0 && cal(x - 1, y) <= k) {//上
            record[x - 1][y] = -1;
            count = count + 1 + dfs(x - 1, y, k);
        }
        if (x < record.length - 1 && record[x + 1][y] == 0 && cal(x + 1, y) <= k) {//下
            record[x + 1][y] = -1;
            count = count + 1 + dfs(x + 1, y, k);
        }
        if (y > 0 && record[x][y - 1] == 0 && cal(x, y - 1) <= k) {//左
            record[x][y - 1] = -1;
            count = count + 1 + dfs(x, y - 1, k);
        }
        if (y < record[0].length - 1 && record[x][y + 1] == 0 && cal(x, y + 1) <= k) {//右
            record[x][y + 1] = -1;
            count = count + 1 + dfs(x, y + 1, k);
        }
        return count;
    }

    public int cal(int x, int y) {//计算坐标p的数位和
        int count = 0;
        while (x >= 1) {
            count = count + x % 10;
            x = x / 10;
        }
        while (y >= 1) {
            count = count + y % 10;
            y = y / 10;
        }
        return count;
    }
}