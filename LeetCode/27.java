class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0, j = 0;//j记录应当放置元素的位置
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == val) {
                i++;
            }
            if (i != nums.length) {
                nums[j] = nums[i];
                j++;
                count++;
            }
        }
        return count;
    }
}