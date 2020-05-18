class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];//动态规划数组dp[i][j]表示nums[i]~nums[j]的乘积大小
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = nums[i];
            max = Math.max(max, dp[i]);
            for (int j = nums.length - 1; j > i; j--) {
                dp[j] = dp[j] * nums[i];
                max = Math.max(max, dp[j]);
            }
        }
        return max;
    }
}