//Solution 1
class Solution {
    //binary search -> O(NlogN)
    public int firstUniqChar(String s) {
        int i;
        int result;
        for (i = 0; i < s.length(); i++) {
            result = find(s.substring(0, i) + s.substring(i + 1, s.length()), s.charAt(i));
            if (result == -1) {
                return i;
            }
        }
        return -1;
    }

    public int find(String s, char x) {
        int len = s.length();
        int result;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            if (x == s.charAt(0)) {
                return 0;
            } else {
                return -1;
            }
        }
        if (s.charAt(len / 2) == x) {
            return len / 2;
        }
        result = find(s.substring(0, len / 2), x);
        if (result != -1) {
            return result;
        }
        result = find(s.substring(len / 2, len), x);
        if (result != -1) {
            return len / 2 + result;
        }
        return -1;
    }
}

class Solution {
    //binary search -> O(NlogN)
    public int firstUniqChar(String s) {
        int[] record = new int[26];
        int i;
        char[] args = s.toCharArray();
        for (i = 0; i < args.length; i++) {
            record[args[i] - "a"] = record[args[i] - "a"] + 1;
        }
        for (i = 0; i < args.length; i++) {
            if (record[args[i] - "a"] == 1) {
                return i;
            }
        }
        return -1;
    }
}