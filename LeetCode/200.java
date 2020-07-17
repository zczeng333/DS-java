class Solution {
    public int numIslands(char[][] grid) {
        //多源的图遍历问题
        int i = 0, j = 0, num = 0;
        while (i < grid.length) {
            if (grid[i][j] == '0') {
                j++;
                if (j == grid[0].length) {
                    i++;
                    j = 0;
                }
            } else {
                num++;
                search(grid, i, j);
                j++;
                if (j == grid[0].length) {
                    i++;
                    j = 0;
                }
            }
        }
        return num;
    }

    public void search(char[][] grid, int x, int y) {//以grid[x][y]为起点遍历所有相邻节点
        Queue<int[]> record = new LinkedList<int[]>();//队列记录已经被置0但邻居还未访问的节点
        grid[x][y] = 0;
        record.offer(new int[]{x, y});
        int[] temp;
        while (record.size() > 0) {
            temp = record.poll();
            if (temp[0] < grid.length - 1 && grid[temp[0] + 1][temp[1]] == '1') {
                grid[temp[0] + 1][temp[1]] = '0';
                record.offer(new int[]{temp[0] + 1, temp[1]});
            }
            if (temp[0] > 0 && grid[temp[0] - 1][temp[1]] == '1') {
                grid[temp[0] - 1][temp[1]] = '0';
                record.offer(new int[]{temp[0] - 1, temp[1]});
            }
            if (temp[1] < grid[0].length - 1 && grid[temp[0]][temp[1] + 1] == '1') {
                grid[temp[0]][temp[1] + 1] = '0';
                record.offer(new int[]{temp[0], temp[1] + 1});
            }
            if (temp[1] > 0 && grid[temp[0]][temp[1] - 1] == '1') {
                grid[temp[0]][temp[1] - 1] = '0';
                record.offer(new int[]{temp[0], temp[1] - 1});
            }
        }
    }
}