class Solution {
    public int[][] map;

    public int surfaceArea(int[][] grid) {
        int sum = 0;
        map = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    sum = sum + 2;//上下
                    sum = sum + Up(i, j) + Down(i, j) + Left(i, j) + Right(i, j);//前后左右
                }
            }
        }
        return sum;
    }

    public int Up(int i, int j) {//map[i][j]与map[i-1][j]之间的表面积
        if (i == 0) {
            return map[i][j];
        }
        return Math.max(0, map[i][j] - map[i - 1][j]);
    }

    public int Down(int i, int j) {//map[i][j]与map[i+1][j]之间的表面积
        if (i == map.length - 1) {
            return map[i][j];
        }
        return Math.max(0, map[i][j] - map[i + 1][j]);
    }

    public int Left(int i, int j) {//map[i][j]与map[i][j-1]之间的表面积
        if (j == 0) {
            return map[i][j];
        }
        return Math.max(0, map[i][j] - map[i][j - 1]);
    }

    public int Right(int i, int j) {//map[i][j]与map[i][j+1]之间的表面积
        if (j == map[0].length - 1) {
            return map[i][j];
        }
        return Math.max(0, map[i][j] - map[i][j + 1]);
    }
}

