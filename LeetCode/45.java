class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];//dp[i]记录第i个位置要跳跃到最后位置所需的最少次数
        int min;
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            min = Integer.MAX_VALUE - 1;
            for (int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); j++) {
                min = Math.min(min, dp[j] + 1);
            }
            dp[i] = min;
        }
        return dp[0];
    }
}