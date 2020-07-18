class Solution {
    public String replaceSpace(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i) + "%20" + s.substring(i + 1);
                i = i + 3;
            } else {
                i++;
            }
        }
        return s;
    }
}