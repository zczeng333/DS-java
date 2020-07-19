class Solution {
    public int[] dp;

    public int integerBreak(int n) {
        dp = new int[n + 1];//dp[i]记录长度为i的绳子被拆分后的最大乘积
        dp[0] = 1;
        dp[1] = 1;
        int max = n - 1;
        for (int i = 1; i <= n / 2; i++) {
            max = Math.max(max, findMax(n - i) * findMax(i));
        }
        return max;
    }

    public int findMax(int n) {//寻找长度为n的最佳分割
        if (dp[n] != 0) {
            return dp[n];
        }
        int max = n;
        for (int i = 1; i <= n / 2; i++) {
            max = Math.max(max, findMax(n - i) * findMax(i));
        }
        dp[n] = max;
        return max;
    }
}