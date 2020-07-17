class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (target <= nums[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int len = nums.length;
        if (nums[len / 2] == target) {
            return len / 2;
        } else if (nums[len / 2] > target) {
            return searchInsert(Arrays.copyOfRange(nums, 0, len / 2), target);
        } else {
            return len / 2 + 1 + searchInsert(Arrays.copyOfRange(nums, len / 2 + 1, len), target);
        }
    }
}