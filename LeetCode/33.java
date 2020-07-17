class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int pos;
        if (nums[0] <= nums[nums.length - 1]) {
            pos = -1;
        }//没有进行旋转
        else {
            pos = findpos(nums, 0, nums.length - 1);
        }//寻找旋转中心，对应有nums[pos-i]>nums[pos],nums[pos+i]>nums[pos]
        if (pos == -1) {
            return binarysearch(nums, 0, nums.length, target);
        }
        if (target == nums[0]) {
            return 0;
        }
        if (target > nums[0]) {
            return binarysearch(nums, 1, pos, target);
        } else {
            return binarysearch(nums, pos, nums.length, target);
        }
    }

    public int findpos(int[] nums, int left, int right) {//寻找nums数组中旋转的位置，left和right为锁定的旋转中心位置左右范围
        if (right - left <= 1) {
            if (nums[right] > nums[left]) {
                return left;
            } else {
                return right;
            }
        }//递归边界条件
        int mid = (left + right) / 2;
        if (nums[mid] > nums[left]) {
            return findpos(nums, mid, right);
        }//旋转位置在右半段
        else {
            return findpos(nums, left, mid);
        }//旋转位置在左半段
    }

    public int binarysearch(int[] nums, int left, int right, int target) {//二分查找元素位置(位置在left~right之间，含左不含右)
        if (left >= right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binarysearch(nums, left, mid, target);
        }//左区间
        else {
            return binarysearch(nums, mid + 1, right, target);
        }//右区间
    }
}