class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] answer = new int[matrix.length * matrix[0].length];
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;//分别记录遍历矩阵的上下左右
        int count = 0;//x,y记录matrix中位置，count记录answer中的位置
        while (left <= right || up <= down) {//当还有没有遍历完的部分
            for (int x = left; x <= right && up <= down; x++) {//上
                answer[count] = matrix[up][x];
                count++;
            }
            up++;
            for (int y = up; y <= down && left <= right; y++) {//右
                answer[count] = matrix[y][right];
                count++;
            }
            right--;
            for (int x = right; x >= left && up <= down; x--) {//下
                answer[count] = matrix[down][x];
                count++;
            }
            down--;
            for (int y = down; y >= up && left <= right; y--) {//左
                answer[count] = matrix[y][left];
                count++;
            }
            left++;
        }
        return answer;
    }
}