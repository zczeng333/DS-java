class Solution {
    public String addStrings(String num1, String num2) {
        int flag = 0;
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int len1 = n1.length - 1;
        int len2 = n2.length - 1;
        int temp;
        int i;
        StringBuilder result = new StringBuilder();
        for (i = 0; i <= Math.min(len1, len2); i++) {
            temp = n1[len1 - i] - '0' + n2[len2 - i] - '0' + flag;
            flag = 0;
            if (temp > 9) {
                temp = temp - 10;
                flag = 1;
            }
            result.insert(0, (char) (temp + '0'));
        }
        if (len1 > len2) {
            while (i <= len1) {
                temp = n1[len1 - i] - '0' + flag;
                flag = 0;
                if (temp > 9) {
                    temp = temp - 10;
                    flag = 1;
                }
                result.insert(0, (char) (temp + '0'));
                i = i + 1;
            }
        } else {
            while (i <= len2) {
                temp = n2[len2 - i] - '0' + flag;
                flag = 0;
                if (temp > 9) {
                    temp = temp - 10;
                    flag = 1;
                }
                result.insert(0, (char) (temp + '0'));
                i = i + 1;
            }
        }
        if (flag == 1) {
            result.insert(0, "1");
        }
        return result.toString();
    }
}