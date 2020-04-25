class Solution {
    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }//不需要修改数组
        char temp = chars[0];//记录当下的数字
        int count = 1;//记录新字符串长度
        int tempv = 1;//记录有多少个重复数字
        int j = 0;//记录应该被修改的位置
        int k;//记录reverse的最后位置
        char[] reverse = new char[4];
        for (int i = 1; i < chars.length; i++) {
            if (temp != chars[i]) {
                chars[j] = temp;//记录之前的字符
                j++;
                count++;//新的字符
                if (tempv != 1) {//相同数组长度不为1时需要将数字纳入字符考虑
                    k = 0;
                    while (tempv != 0) {//将长度数值(12)取为倒数(21)
                        count++;//之前重复字符串的长度
                        reverse[k] = (char) (tempv % 10 + '0');
                        tempv = tempv / 10;
                        k++;
                    }
                    k--;
                    while (k >= 0) {
                        chars[j] = reverse[k];
                        j++;
                        k--;
                    }
                }
                tempv = 1;//新字符temp的长度
                temp = chars[i];//新字符
            } else {
                tempv++;
            }
        }
        chars[j] = temp;//记录之前的字符
        j++;
        if (tempv != 1) {//相同数组长度不为1时需要将数字纳入字符考虑
            k = 0;
            while (tempv != 0) {//将长度数值(12)取为倒数(21)
                count++;//之前重复字符串的长度
                reverse[k] = (char) (tempv % 10 + '0');
                tempv = tempv / 10;
                k++;
            }
            k--;
            while (k >= 0) {
                chars[j] = reverse[k];
                j++;
                k--;
            }
        }
        return count;
    }
}	