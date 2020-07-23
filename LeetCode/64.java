class Solution {
    int[][] dp;
    int[][] record;

    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        record = new int[grid.length][grid[0].length];
        dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
        record[grid.length - 1][grid[0].length - 1] = -1;
        findMin(grid, 0, 0);
        return dp[0][0];
    }

    public void findMin(int[][] grid, int x, int y) {
        if (record[x][y] != 0) {
            return;
        }
        int min = Integer.MAX_VALUE;
        if (x < grid.length - 1) {//下
            if (record[x + 1][y] == 0) {
                findMin(grid, x + 1, y);
            }
            if (min > dp[x + 1][y]) {
                min = dp[x + 1][y];
            }
        }
        if (y < grid[0].length - 1) {//右
            if (dp[x][y + 1] == 0) {
                findMin(grid, x, y + 1);
            }
            if (min > dp[x][y + 1]) {
                min = dp[x][y + 1];
            }
        }
        dp[x][y] = grid[x][y] + min;
        record[x][y] = -1;
    }
}