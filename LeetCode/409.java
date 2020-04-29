class Solution {
    public int longestPalindrome(String s) {
        int[] hash = new int[58];
        int max = 0, flag = 0, i;
        for (i = 0; i < s.length(); i++) {
            hash[(int) (s.charAt(i) - 'A')]++;
        }
        for (i = 0; i < 58; i++) {
            if (hash[i] % 2 == 1) {
                max = max + hash[i] - 1;
                flag = 1;//可以再加一个
            } else {
                max = max + hash[i];
            }
        }
        if (flag == 1) {
            max++;
        }
        return max;
    }
}