class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, pos = m + n - 1;
        while (pos >= 0) {
            if (i < 0) {
                while (pos >= 0) {
                    A[pos] = B[j];
                    pos--;
                    j--;
                }
                break;
            }
            if (j < 0) {
                while (pos >= 0) {
                    A[pos] = A[i];
                    pos--;
                    i--;
                }
                break;
            }
            if (A[i] > B[j]) {
                A[pos] = A[i];
                i--;
            } else {
                A[pos] = B[j];
                j--;
            }
            pos--;
        }
    }
}