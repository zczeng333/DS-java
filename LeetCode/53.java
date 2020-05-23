class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, i = nums.length - 1, count = 0;
        while (i >= 0) {
            count = count + nums[i];
            if (count > max) {
                max = count;
            }
            if (count < 0) {
                count = 0;
            }
            i--;
        }
        return max;
    }
}