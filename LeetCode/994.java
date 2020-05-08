class Solution {
    public int orangesRotting(int[][] grid) {
        int size = 1, step = 0, i, j, temp = 0;//temp1记录上一次遍历的1数目，temp2记录本次遍历的1数目
        ArrayList<int[]> record = new ArrayList<int[]>();
        while (size != 0) {//仍有剩余good未污染且仍未稳定时
            step++;//记录步数
            temp = 0;//记录本次的good orange数目
            for (i = 0; i < grid.length; i++) {
                for (j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        temp++;
                        if (Contaminate(grid, i, j)) {//判断该step下grid[i][j]能否被污染
                            record.add(new int[]{i, j});
                        }
                    }
                }
            }
            if (temp == 0) {
                break;
            }//全部污染
            size = record.size();
            for (int k = 0; k < size; k++) {
                grid[record.get(k)[0]][record.get(k)[1]] = 2;
            }
            record.clear();
        }
        if (temp == 0) {
            return step - 1;
        } else {
            return -1;
        }
    }

    public boolean Contaminate(int[][] grid, int i, int j) {
        if (i > 0 && grid[i - 1][j] == 2) {
            return true;
        }
        if (i < grid.length - 1 && grid[i + 1][j] == 2) {
            return true;
        }
        if (j > 0 && grid[i][j - 1] == 2) {
            return true;
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == 2) {
            return true;
        }
        return false;
    }
}