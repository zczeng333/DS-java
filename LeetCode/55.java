class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int i, start = 0, end, record = nums[0];
        while (start != record) {
            i = start;
            start = record;
            end = record;
            for (; i <= end; i++) {
                record = Math.max(record, i + nums[i]);
                if (record >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}