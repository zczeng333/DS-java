class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int sublen = 0;
        int i, j;
        String s1;
        String s2;
        String str = "";
        for (i = 0; i < len - sublen / 2; i++) {
            s1 = oddstring(i, s);
            s2 = evenstring(i, s);
            if (s1.length() > sublen) {
                str = s1;
                sublen = s1.length();
            }
            if (s2.length() > sublen) {
                str = s2;
                sublen = s2.length();
            }
        }
        return str;
    }

    public String oddstring(int i, String s) {//m,m+1,...,i,...,2i-m
        int j = i + 1;
        i = i - 1;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public String evenstring(int i, String s) {//m,m+1,...i,i+1,...2i+1-m
        if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
            return "";
        }
        int j = i + 1;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}

