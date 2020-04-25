class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] record = new int[len][len];
        int i, j, max_temp;
        int max_len = 1;
        for (i = 0; i < len; i++) {
            record[i][i] = 1;
        }
        for (i = len - 1; i >= 0; i--) {//遍历顺序要保证j-1和i+1是最优解
            for (j = i + 1; j < len; j++) {//j从前往后，i从后往前
                max_temp = Math.max(record[i][j - 1], record[i + 1][j]);
                if (s.charAt(i) == s.charAt(j)) {
                    max_temp = Math.max(max_temp, 2 + record[i + 1][j - 1]);
                }
                record[i][j] = max_temp;
                max_len = Math.max(max_len, max_temp);
            }
        }
        return max_len;
    }
}