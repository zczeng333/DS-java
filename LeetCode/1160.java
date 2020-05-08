class Solution {
    public int countCharacters(String[] words, String chars) {
        int i, j, len = 0;
        int[] hash = new int[26];
        for (i = 0; i < chars.length(); i++) {
            hash[(int) (chars.charAt(i) - 'a')]++;
        }
        for (i = 0; i < words.length; i++) {
            int[] count = new int[26];
            for (j = 0; j < words[i].length(); j++) {
                count[(int) (words[i].charAt(j) - 'a')]++;
            }
            for (j = 0; j < 26; j++) {
                if (hash[j] < count[j]) {
                    break;
                }
            }
            if (j == 26) {
                len = len + words[i].length();
            }
        }
        return len;
    }
}