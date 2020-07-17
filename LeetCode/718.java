class Solution {
    public int findLength(int[] A, int[] B) {
        int startA = 0, endA = 1, startB = B.length - 1, endB = B.length, maxlen = 0;//start与end分别代表对比子串的起止位置[start,end)
        while (endA - startA > maxlen) {
            maxlen = Math.max(maxlen, FindMax(Arrays.copyOfRange(A, startA, endA), Arrays.copyOfRange(B, startB, endB)));
            if (endA < A.length) {
                endA++;
            } else {
                endB--;
            }
            if (startB > 0) {
                startB--;
            } else {
                startA++;
            }
        }
        return maxlen;
    }

    public int FindMax(int[] x, int[] y) {
        int upper = Math.min(x.length, y.length), len = 0, count = 0;
        for (int j = 0; j < upper; j++) {
            if (x[j] == y[j]) {
                count++;
            } else {
                len = Math.max(count, len);
                count = 0;
            }
        }
        len = Math.max(len, count);
        return len;
    }
}