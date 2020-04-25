class Solution {
    public int lengthOfLastWord(String s) {
        int end;
        int start;
        for (end = s.length() - 1; end >= 0; end--) {
            if (judge(s.charAt(end))) {
                break;
            }
        }
        if (end == -1) {
            return 0;
        }
        for (start = end; start >= 0; start--) {
            if (judge(s.charAt(start))) {
                continue;
            }
            start = start + 1;
            break;
        }
        String word = s.substring(Math.max(start, 0), end + 1);
        return word.length();
    }

    public boolean judge(char x) {
        return x != " ".charAt(0);
    }
}