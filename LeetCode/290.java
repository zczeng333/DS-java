class Solution {
    public boolean wordPattern(String pattern, String str) {
        int len = 1;
        int i, j;
        if (str.length() == 0) {
            len = 0;
        } else {
            for (i = 0; i < str.length(); i++) {//calculate number of words in str
                if (str.charAt(i) == ' ') {
                    len = len + 1;
                }
            }
        }
        if (len != pattern.length()) {//when pattern.length != str.length()
            return false;
        } else if (len == 0) {
            return true;
        }
        int[] p = new int[len];
        int[] s = new int[len];
        String s_temp;
        int temp = 0;//record where to start the next substring
        for (i = 0; i < len; i++) {
            p[i] = (int) (pattern.charAt(i) - 'a');
            for (j = temp; j < str.length(); j++) {
                if (str.charAt(j) == ' ') {
                    s_temp = str.substring(temp, j);
                    temp = j + 1;
                    s[i] = s_temp.hashCode();
                    break;
                }
            }
        }
        s_temp = str.substring(temp, str.length());//add last string
        s[len - 1] = s_temp.hashCode();
        return judge(s, p) && judge(p, s);
    }

    public boolean judge(int[] s1, int[] s2) {
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        int i, j;
        int count = 0;    //length of ArrayList
        for (i = 0; i < s1.length; i++) {
            for (j = 0; j < count; j++) {
                if ((int) r1.get(j) == s1[i]) {
                    if ((int) r2.get(j) != s2[i]) {
                        return false;
                    }
                    break;
                }
            }
            if (j == count) {
                r1.add(s1[i]);
                r2.add(s2[i]);
                count = count + 1;
            }
        }
        return true;
    }
}