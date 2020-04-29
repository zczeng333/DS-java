class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];//dp[i]表示i元的最少兑换方式所需钱币数
        int min, temp;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    temp = dp[i - coins[j]];
                    if (temp != -1 && min > temp + 1) {//兑换i-coins[j]所需的钱币数+1
                        min = temp + 1;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            }//没有可用兑换方式
            else {
                dp[i] = min;
            }
        }
        return dp[amount];
    }
}