class Solution {
    public String compressString(String S) {
        int i = 0, count, pos;
        StringBuilder str = new StringBuilder();
        char temp;
        while (i < S.length()) {
            temp = S.charAt(i);
            str.append(temp);
            count = 0;
            while (i < S.length() && S.charAt(i) == temp) {
                count++;
                i++;
            }
            pos = str.length();
            while (count > 0) {
                str.insert(pos, (char) (count % 10 + '0'));
                count = count / 10;
            }
        }
        if (str.length() < S.length()) {
            return str.toString();
        }
        return S;
    }
}