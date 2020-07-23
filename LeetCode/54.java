class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new LinkedList<Integer>();
        if (matrix.length == 0) {
            return answer;
        }
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;//分别记录遍历矩阵的上下左右
        while (left <= right || up <= down) {//当还有没有遍历完的部分
            for (int x = left; x <= right && up <= down; x++) {//上
                answer.add(matrix[up][x]);
            }
            up++;
            for (int y = up; y <= down && left <= right; y++) {//右
                answer.add(matrix[y][right]);
            }
            right--;
            for (int x = right; x >= left && up <= down; x--) {//下
                answer.add(matrix[down][x]);
            }
            down--;
            for (int y = down; y >= up && left <= right; y--) {//左
                answer.add(matrix[y][left]);
            }
            left++;
        }
        return answer;
    }
}