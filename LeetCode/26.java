class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 1;
        int j = 1;//记录应当防止元素的位置
        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] == nums[i - 1]) {
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