//Solution 1: 213ms
class Solution {
    public String reverseVowels(String s) {
        ArrayList str = new ArrayList();
        ArrayList record = new ArrayList();
        StringBuilder return_s = new StringBuilder();
        int i, j;
        int len = s.length();
        char c;
        for (i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                str.add("" + s.substring(0, i));
                s = s.substring(i + 1, s.length());
                record.add(c);
                i = -1;
            }
        }
        if (s.length() != 0) {
            str.add(s);
        }
        i = record.size() - 1;
        j = 0;
        while (i >= 0 && j < str.size()) {
            return_s.append(str.get(j) + "" + record.get(i));
            i = i - 1;
            j = j + 1;
        }
        while (j < str.size()) {
            return_s.append(str.get(j));
            j = j + 1;
        }
        while (i >= 0) {
            return_s.append("" + record.get(i));
            i = i - 1;
        }
        return return_s.toString();
    }
}

//Solution 2: 3ms
class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char temp;
        char[] str = s.toCharArray();
        while (i < j) {
            while (i < j && !judge(str[i])) {
                i = i + 1;
            }
            while (j > i && !judge(str[j])) {
                j = j - 1;
            }
            if (i != j) {
                temp = str[i];
                str[i] = str[j];
                str[j] = temp;
            }
            i = i + 1;
            j = j - 1;
        }
        return String.valueOf(str);
    }

    public boolean judge(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}