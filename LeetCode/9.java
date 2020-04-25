class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int origin = x;
        while (origin > 0) {
            reverse = 10 * reverse + origin % 10;
            origin = origin / 10;
        }
        if (reverse == x) {
            return true;
        }
        return false;
    }
}