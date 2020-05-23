class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        int[] dp = new int[nums.length];//dp[i]记录从i开始到当前位置的连续数组和mod k
        int i = nums.length - 1;
        while (i >= 0) {
            dp[i] = nums[i] % k;
            for (int j = nums.length - 1; j > i; j--) {
                dp[j] = (dp[j] + nums[i]) % k;
                if (dp[j] == 0) {
                    return true;
                }
            }
            i--;
        }
        return false;
    }
}