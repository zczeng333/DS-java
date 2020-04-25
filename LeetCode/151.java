class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            temp = temp.delete(0, temp.length());
            while (i < s.length() && s.charAt(i) != (" ").charAt(0)) {
                temp = temp.append("" + s.charAt(i));
                i = i + 1;
            }
            if (temp.length() != 0) {
                str.insert(0, temp.toString() + " ");
            }
        }
        if (str.length() == 0) {
            return "";
        }
        return str.deleteCharAt(str.length() - 1).toString();
    }
}