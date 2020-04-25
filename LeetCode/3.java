class Solution {
    int[] record = new int[128];//记录截止第i位的最长序列中各字符的出现位置

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] l = new int[len];
        int temp = (byte) s.charAt(0);
        record[temp] = 1;
        l[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            temp = (byte) s.charAt(i);
            if (record[temp] == 0) {//字符s.charAt(i)没有出现过
                l[i] = l[i - 1] + 1;
            } else {//字符s.charAt(i)出现过
                l[i] = i + 1 - record[temp];
                update(record[temp]);
            }
            record[temp] = i + 1;//记录出现位置(从1开始记录)
            if (max < l[i]) {
                max = l[i];
            }
        }
        return max;
    }

    public void update(int ind) {//更新record矩阵，将小于index的字符索引置为0
        for (int j = 0; j < 128; j++) {
            if (record[j] < ind) {
                record[j] = 0;
            }
        }
    }
}