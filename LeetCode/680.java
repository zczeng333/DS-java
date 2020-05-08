class Solution {
    public boolean validPalindrome(String s) {
        int temp;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return judge(s.substring(i + 1, j + 1)) || judge(s.substring(i, j));
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean judge(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}