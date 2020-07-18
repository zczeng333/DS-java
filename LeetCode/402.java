class Solution {
    public String removeKdigits(String num, int k) {
        String answer = "";
        int min, min_ind = -1, temp;
        k = num.length() - k;//需要保留的数字位数
        if (k == num.length()) {
            answer = num;
        }
        while (k > 0 && k < num.length()) {//从左至右注意选择最小数字
            num = num.substring(min_ind + 1);
            min = (int) num.charAt(0) - (int) '0';
            min_ind = 0;
            for (int i = 1; i <= num.length() - k; i++) {
                temp = (int) num.charAt(i) - (int) '0';
                if (temp < min) {
                    min = temp;
                    min_ind = i;
                }
            }
            answer = answer + num.charAt(min_ind);
            k--;
        }
        answer = check(answer);
        return answer;
    }

    public String check(String num) {//对num字符串进行合法性检验与修正
        int i = 0;
        while (i < num.length() && num.charAt(i) == '0') {
            i++;
        }
        num = num.substring(i);
        if (num.equals("")) {
            num = "0";
        }//空字符串
        return num;
    }
}