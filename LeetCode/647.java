class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] record = new boolean[len][len];
        int i, j;
        int count = len;
        for (i = 0; i < len; i++) {
            record[i][i] = true;
        }
        for (i = len - 1; i >= 0; i--) {
            for (j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 >= j - 1) {
                        record[i][j] = true;
                        count++;
                    } else if (record[i + 1][j - 1]) {
                        record[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}