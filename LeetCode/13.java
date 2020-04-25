class Solution {
    public int romanToInt(String s) {
        String[] c = new String[]{"I", "V", "X", "L", "C", "D", "M", "IV", "IX", "XL", "XC", "CD", "CM"};
        int[] value = new int[]{1, 5, 10, 50, 100, 500, 1000, 4, 9, 40, 90, 400, 900};
        String temp;
        int i, j;
        int count = 0;
        for (i = 0; i < s.length(); i++) {
            j = 13;
            if (i + 1 < s.length()) {// double operator has higher priority
                temp = s.substring(i, i + 2);
                for (j = 7; j < 13; j++) {
                    if (temp.equals(c[j])) {
                        count = count + value[j];
                        i = i + 1;    //skip next character
                        break;
                    }
                }
            }
            if (j == 13) {// not a double operator
                temp = s.substring(i, i + 1);
                for (j = 0; j < 7; j++) {
                    if (temp.equals(c[j])) {
                        count = count + value[j];
                        break;
                    }
                }
            }
        }
        return count;
    }
}