class Solution {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];//动态规划，dp[i]记录由i开始的最长工作时间
        dp[nums.length - 1] = nums[nums.length - 1];
        dp[nums.length - 2] = nums[nums.length - 2];
        for (int i = nums.length - 3; i >= 0; i--) {
            dp[i] = nums[i] + Math.max(dp[i + 2], dp[i + 1] - nums[i + 1]);
        }
        return Math.max(dp[0], dp[1]);
    }
}