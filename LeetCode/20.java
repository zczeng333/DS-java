class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int i, j;
        int len;
        while (s.length() != 0) {
            i = 0;
            len = 0;
            while (i < s.length() && judge_left(s, i) != 0) {//寻找第一个右括号位置
                i++;
            }//此时i指向第一个右括号
            if (i == 0 || i == s.length()) {
                return false;
            }//右括号在最左边或找不到右括号
            j = i - 1;
            while (j - len >= 0 && i + len < s.length() && judge_right(s, i + len) != 0) {
                if (judge_left(s, j - len) != judge_right(s, i + len)) {
                    return false;
                }
                len++;
            }
            s = s.substring(0, j - len + 1) + s.substring(i + len, s.length());
            System.out.print(s);
        }
        return true;
    }

    public int judge_left(String s, int i) {
        if (s.charAt(i) == '(') {
            return 1;
        }
        if (s.charAt(i) == '[') {
            return 2;
        }
        if (s.charAt(i) == '{') {
            return 3;
        }
        return 0;
    }

    public int judge_right(String s, int j) {
        if (s.charAt(j) == ')') {
            return 1;
        }
        if (s.charAt(j) == ']') {
            return 2;
        }
        if (s.charAt(j) == '}') {
            return 3;
        }
        return 0;
    }
}