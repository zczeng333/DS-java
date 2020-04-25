//Solution 1: 44ms
class Solution {
    public String reverseWords(String s) {
        if (s.length() <= 1) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        StringBuilder word = new StringBuilder();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (s.charAt(i) == (" ").charAt(0)) {
                str.append(word.toString() + " ");
                word = word.delete(0, word.length());
            } else {
                word = word.insert(0, "" + temp);
            }
            if (i == s.length() - 1) {
                str.append(word.toString() + " ");
            }
        }
        str.delete(str.length() - 1, str.length());
        return str.toString();
    }
}

//Solution 2: 8ms
class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            str[i] = reverse(str[i]);
        }
        return String.join(" ", str);
    }

    public String reverse(String s) {
        char temp;
        int len = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < len - i - 1; i++) {
            temp = str[i];
            str[i] = str[len - i - 1];
            str[len - i - 1] = temp;
        }
        return String.valueOf(str);
    }
}