class Solution {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int a = 1, b = 1, temp;//a记录前两项，b记录前一项
        for (int i = 2; i <= n; i++) {
            temp = b;
            b = (a + b) % 1000000007;
            a = temp;
        }
        return b;
    }
}