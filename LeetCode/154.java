class Solution {
    public int findMin(int[] nums) {
        int mid, left = 0, right = nums.length - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        mid = (left + right) / 2;
        return nums[mid];
    }
}