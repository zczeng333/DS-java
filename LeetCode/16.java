class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i, left, right, sum, min = Integer.MAX_VALUE;
        for (i = 0; i < nums.length - 2; i++) {//确保至少三个数
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }//避免重复计算
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right] - target;
                if (sum == 0) {
                    return target;
                }
                if (Math.abs(min) > Math.abs(sum)) {
                    min = sum;
                }
                if (sum > 0) {//右指针左移
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {//左指针右移
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return target + min;
    }
}