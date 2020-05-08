class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }
        String substr1 = str1 + "", substr2 = str2 + "";
        while (true) {
            if (substr1.length() == 0 || substr2.length() == 0) {
                break;
            }//没有公因子
            if (substr1.length() > substr2.length()) {
                substr1 = FindLongestSubstring(str1, substr1.length());
            } else if (substr1.length() < substr2.length()) {
                substr2 = FindLongestSubstring(str2, substr2.length());
            } else {
                if (substr1.equals(substr2)) {
                    return substr1;
                } else {
                    substr1 = FindLongestSubstring(str1, substr1.length());
                    substr2 = FindLongestSubstring(str2, substr2.length());
                }
            }
        }
        return "";
    }

    public String FindLongestSubstring(String str, int max_len) {//寻找str的长度小于max_len的最长子串
        int len = str.length();
        for (int i = max_len - 1; i > 0; i--) {
            if (len % i == 0) {//整除时判断是否是子串,从长至段
                String substr = str.substring(0, i);
                int j = i;
                while (j < len) {
                    if (!substr.equals(str.substring(j, j + i))) {
                        break;
                    }
                    j = j + i;
                }
                if (j == len) {
                    return substr;
                }
            }
        }
        return "";
    }
}