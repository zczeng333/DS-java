class Solution {
    public int[][] map;

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0, temp;
        map = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    temp = search(i, j);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    public int search(int i, int j) {
        int count = 1;
        map[i][j] = 0;
        if (i > 0 && map[i - 1][j] == 1) {
            count = count + search(i - 1, j);
        }//上
        if (i < map.length - 1 && map[i + 1][j] == 1) {
            count = count + search(i + 1, j);
        }//下
        if (j > 0 && map[i][j - 1] == 1) {
            count = count + search(i, j - 1);
        }//左
        if (j < map[0].length - 1 && map[i][j + 1] == 1) {
            count = count + search(i, j + 1);
        }//右
        return count;
    }
}