class Solution {
    public String intToRoman(int num) {
        int[] value = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] c = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        String str = "";
        int i = value.length - 1;
        int temp = value[i];
        while (true) {
            while (num - temp >= 0) {
                num = num - temp;
                str = str + c[i];
            }
            if (num == 0) {
                break;
            }
            i = i - 1;
            temp = value[i];
        }
        return str;
    }
}