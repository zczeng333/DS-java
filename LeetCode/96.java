class Solution {
    public int[] dp;

    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        int sum;
        dp = new int[n + 1];//动态规划数组，用于计算不同n下的tree数
        dp[0] = 1;
        dp[1] = 1;//一个node时只有一种树
        for (int i = 2; i <= n; i++) {
            sum = 0;
            for (int j = 0; i > 2 * j + 1; j++) {
                sum = sum + 2 * dp[j] * dp[i - j - 1];
            }
            if (i % 2 == 1) {
                sum = sum + dp[i / 2] * dp[i / 2];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}