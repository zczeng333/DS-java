class Solution {
    public int myAtoi(String str) {
        int value = 0;
        int i = 0, flag = 1, temp;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }//找到第一个非空格字符
        if (i == str.length() || ((str.charAt(i) > '9' || str.charAt(i) < '0') && str.charAt(i) != '-' && str.charAt(i) != '+')) {
            return 0;
        }
        if (str.charAt(i) == '-') {
            i++;
            flag = -1;
        }//负数
        else if (str.charAt(i) == '+') {
            i++;
        }
        if (i == str.length() || str.charAt(i) > '9' || str.charAt(i) < '0') {
            return 0;
        }
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            temp = flag * (int) (str.charAt(i) - '0');
            if (flag == 1 && (value > Integer.MAX_VALUE / 10 || (value == Integer.MAX_VALUE / 10 && temp > 7))) {
                return Integer.MAX_VALUE;
            }
            if (flag == -1 && (value < Integer.MIN_VALUE / 10 || (value == Integer.MIN_VALUE / 10 && temp < -8))) {
                return Integer.MIN_VALUE;
            }
            value = 10 * value + temp;
            i++;
        }
        return value;
    }
}