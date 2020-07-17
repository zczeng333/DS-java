class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left, right, temp;
        temp = binarysearch(nums, 0, nums.length - 1, target);
        if (temp == -1) {
            return new int[]{-1, -1};
        }
        left = temp;
        right = temp;
        while (temp != nums.length - 1 && nums[temp + 1] == target) {//还没有找到右边界
            temp = binarysearch(nums, temp + 1, nums.length - 1, target);
            if (temp == -1) {
                break;
            }
            right = temp;
        }
        temp = left;
        while (temp != 0 && nums[temp - 1] == target) {//还没有找到左边界
            temp = binarysearch(nums, 0, temp - 1, target);
            if (temp == -1) {
                break;
            }
            left = temp;
        }
        return new int[]{left, right};
    }

    public int binarysearch(int[] nums, int left, int right, int target) {
        if (left >= right) {
            if (nums[left] != target) {
                return -1;
            } else {
                return left;
            }
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarysearch(nums, left, mid - 1, target);
        } else {
            return binarysearch(nums, mid + 1, right, target);
        }
    }
}