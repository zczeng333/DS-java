class Solution {
    public boolean isSubsequence(String s, String t) {
        int[] hash_s = new int[26];
        int[] hash_t = new int[26];
        int i, j;
        char c;
        for (i = 0; i < s.length(); i++) {
            hash_s[s.charAt(i) - 'a']++;
        }
        for (i = 0; i < t.length(); i++) {
            hash_t[t.charAt(i) - 'a']++;
        }
        for (i = 0; i < s.length(); i++) {
            j = 0;
            c = s.charAt(i);
            hash_s[c - 'a']--;
            while (j < t.length() && t.charAt(j) != c) {
                hash_t[t.charAt(j) - 'a']--;
                j++;
            }
            if (j == t.length()) {
                return false;
            }
            hash_t[t.charAt(j) - 'a']--;
            t = t.substring(j + 1);
            for (j = 0; j < 26; j++) {
                if (hash_t[j] < hash_s[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}