class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        long min = matrix[0][0], max = matrix[n - 1][n - 1], mid = (min + max) / 2;
        //min和max为矩阵的搜索的最大最小值，mid为二分界限
        int count = NoBiggerThan(matrix, mid);
        while (min < max) {//当前后两次count没有变号时，说明还没找到
            if (count >= k) {
                max = mid;
            }//mid设置高了，需要降低（注意max仍有可能是答案）
            else {
                min = mid + 1;
            }//mid设置低了，需要提高（注意min不可能是答案）
            mid = (min + max) / 2;
            count = NoBiggerThan(matrix, mid);
        }
        return (int) mid;
    }

    public int NoBiggerThan(int[][] matrix, long mid) {//统计matrix中不大于mid的元素数目
        int x = matrix.length - 1, y = 0, count = 0;//起始遍历位置为矩阵左下角
        while (x >= 0 && y < matrix.length) {//当遍历位置仍然在矩阵范围内时
            if (matrix[x][y] > mid) {
                x--;
            }//大于mid，需要上移
            else {//小于等于mid，需要右移
                y++;
                count = count + x + 1;
            }
        }
        return count;
    }
}