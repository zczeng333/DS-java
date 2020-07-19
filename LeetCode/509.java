class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int a = 0, b = 1, temp;//a记录前两项，b记录前一项
        for (int i = 2; i <= N; i++) {
            temp = b;
            b = (a + b) % 1000000007;
            a = temp;
        }
        return b;
    }
}