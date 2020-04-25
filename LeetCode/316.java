public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        int[] record = new int[26];
        int i;
        int index = 0;
        for (i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(index)) {
                index = i;
            }
            record[s.charAt(i) - 'a']--;
            if (record[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.charAt(index) + removeDuplicateLetters(s.substring(index + 1).replaceAll("" + s.charAt(index), ""));
    }
}