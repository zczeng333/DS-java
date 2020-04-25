//Solution 1：超时
class Solution {
    public int numDistinct(String s, String t) {//s为长序列，t为短序列
        int[] hash_s = new int[128];
        int[] hash_t = new int[128];
        for (int i = 0; i < s.length(); i++) {//构建s的hash table
            hash_s[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hash_t[t.charAt(i) - '0']++;
        }
        return count(s, t, hash_s, hash_t);
    }

    public int count(String s, String t, int[] count_s, int[] count_t) {
        if (s.length() < t.length()) {
            return 0;
        }
        if (t.length() == 0) {
            return 1;
        }
        int[] hash_s = count_s.clone();
        int[] hash_t = count_t.clone();
        int num = 0;
        int i = 0;
        int j;
        char c = t.charAt(0);
        hash_t[c - '0']--;//将t.charAt(0)排除在外
        while (hash_s[c - '0'] > 0 && i < s.length()) {//查找s中所有c的位置
            hash_s[s.charAt(i) - '0']--;
            if (s.charAt(i) == c) {//匹配s.substring(i+1)与t.substring(1)
                for (j = 0; j < 128; j++) {//保证s.substring(i+1)的元素足以匹配t.substring(1)
                    if (hash_t[j] > hash_s[j]) {
                        break;
                    }
                }
                if (j != 128) {
                    break;
                }
                num = num + count(s.substring(i + 1), t.substring(1), hash_s, hash_t);
            }
            i++;
        }
        return num;
    }
}

class Solution {
    public int numDistinct(String s, String t) {//s为长序列，t为短序列
        if (t.length() > s.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];//dp[i][j]表示s[0]~s[j]包含多少个t[0]~t[j]的子序列
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }//s[0][i]能表示空字符，对应dp起点
        for (int i = 1; i <= s.length(); i++) {//遍历s所有字符（对应dp所有行）
            for (int j = 1; j <= Math.min(t.length(), i); j++) {//遍历t所有字符（对应dp所有列）
                if (t.charAt(j - 1) == s.charAt(i - 1)) {//当t[j]==s[i]时，更新dp
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}