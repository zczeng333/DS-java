class Solution {
    public int maxDistance(int[][] grid) {
        int step = 1;
        boolean flag = true;
        while (flag) {//当仍有0未被遍历到时
            flag = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        flag = accessible(grid, i, j, step) || flag;
                    }
                }
            }
            step++;
        }
        if (step == 2) {
            return -1;
        }
        return step - 2;
    }

    public boolean accessible(int[][] grid, int i, int j, int step) {
        if (i > 0 && grid[i - 1][j] == step) {
            grid[i][j] = step + 1;
            return true;
        }//上
        if (i < grid.length - 1 && grid[i + 1][j] == step) {
            grid[i][j] = step + 1;
            return true;
        }//下
        if (j > 0 && grid[i][j - 1] == step) {
            grid[i][j] = step + 1;
            return true;
        }//左
        if (j < grid[0].length - 1 && grid[i][j + 1] == step) {
            grid[i][j] = step + 1;
            return true;
        }//右
        return false;
    }
}