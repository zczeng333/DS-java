class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];//dp[i]记录由0~i的最长上升子序列长度
        int max;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}