//Solution1
class Solution {
    //O(N) for best-case, O(N^2) for worst-case
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (t.length() != len) {
            return false;
        }
        int i;
        char c1, c2, temp1, temp2;
        while (len > 0) {
            c1 = s.charAt(0);
            c2 = t.charAt(0);
            s = s.substring(1, len);
            t = t.substring(1, len);
            len = len - 1;
            for (i = 0; i < len; i++) {
                temp1 = s.charAt(i);
                temp2 = t.charAt(i);
                if ((temp1 == c1 && temp2 != c2) || (temp1 != c1 && temp2 == c2)) {
                    return false;
                }
                if (temp1 == c1 && temp2 == c2) {
                    s = s.substring(0, i) + s.substring(i + 1, len);
                    t = t.substring(0, i) + t.substring(i + 1, len);
                    len = len - 1;
                    i = i - 1;
                }
            }
        }
        return true;
    }
}

//Solution2
class Solution {
    //Hash characters into char[] map=new char[128] (ascii)
    public boolean isIsomorphic(String s, String t) {
        return map(s, t) && map(t, s);
    }

    public boolean map(String s, String t) {
        char[] map = new char[128];
        char c1, c2;
        for (int i = 0; i < s.length(); i++) {
            c1 = s.charAt(i);
            c2 = t.charAt(i);
            if (map[c1 - (char) 0] == (char) 0) {
                map[c1 - (char) 0] = c2;
            } else {
                if (map[c1 - (char) 0] != c2) {
                    return false;
                }
            }
        }
        return true;
    }
}