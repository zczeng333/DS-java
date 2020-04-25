class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        int[] record = new int[26];
        ArrayList c_delete = new ArrayList();    //record char needs to be deleted
        int i, temp, maxv;
        for (i = 0; i < s.length(); i++) {//count #appearance for each char in s
            record[s.charAt(i) - 'a']++;
        }
        for (i = 0; i < 26; i++) {
            if (record[i] >= 1 && record[i] < k) {
                c_delete.add((char) ('a' + i));
            }
        }
        if (c_delete.size() == 0) {
            return s.length();
        }
        temp = 0;
        maxv = 0;
        for (i = 0; i < s.length(); i++) {
            if (delete(s.charAt(i), c_delete)) {
                maxv = Math.max(maxv, longestSubstring(s.substring(temp, i), k));
                temp = i + 1;
            }
        }
        if (temp < s.length()) {
            maxv = Math.max(maxv, Math.max(maxv, longestSubstring(s.substring(temp, s.length()), k)));
        }
        return maxv;
    }

    public boolean delete(char c, ArrayList a) {
        for (int i = 0; i < a.size(); i++) {
            if (c == (char) a.get(i)) {
                return true;
            }
        }
        return false;
    }
}