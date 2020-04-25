class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min_ind = 0;
        int min_v = nums[min_ind];
        int i = 1;
        while (i < nums.length - 1 && min_v >= nums[i]) {//从左至右找到第一个满足min_v<nums[i]的i位置
            min_ind = i;
            min_v = nums[min_ind];
            i = i + 1;
        }
        if (i == nums.length - 1) {
            return false;
        }//不存在左边数小于右边数的情况
        int max_ind = find_max(nums, i);
        int max_v = nums[max_ind];
        while (i < nums.length - 1) {//只有1~length-2中的元素可能为三元组
            if (i == max_ind) {//i不再能作为max_ind，需要寻找i右边的max
                max_ind = find_max(nums, i);
                max_v = nums[max_ind];
            }
            if (min_v < nums[i] && max_v > nums[i]) {
                return true;
            }//找到三元组
            if (nums[i] < min_v) {//更新min_v&min_ind
                min_ind = i;
                min_v = nums[min_ind];
            }
            i++;
        }
        return false;
    }

    public int find_max(int[] nums, int i) {//寻找i右边的最大值
        i = i + 1;
        int max_ind = i;
        while (i < nums.length) {
            if (nums[max_ind] < nums[i]) {
                max_ind = i;
            }
            i++;
        }
        return max_ind;//右边不存在max值
    }
}