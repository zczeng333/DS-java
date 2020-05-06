class Solution {
    public int minIncrementForUnique(int[] A) {
        int i = 1, j = 1, count = 0, temp_i, temp;
        Arrays.sort(A);
        while (i < A.length) {
            while (i < A.length && A[i] > A[i - 1]) {
                i++;
            }//找到相等的数组元素i(i需要被增大)
            if (i == A.length) {
                break;
            }//已满足要求
            if (j < i) {
                j = i;
            }
            while (j < A.length && A[j] <= A[j - 1] + 1) {
                j++;
            }//找到第一个可以插入的位置j(j-1与j之间可以插入)
            temp_i = i;
            count = count + A[j - 1] - A[i] + 1;
            while (temp_i < j - 1) {
                A[temp_i] = A[temp_i + 1];
                temp_i++;
            }
            A[temp_i] = A[temp_i - 1] + 1;
        }
        return count;
    }
}