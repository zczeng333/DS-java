class Solution {
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] record = new int[2];
        int i = 0, j = 0, flag;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {//重复元素
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
                i++;//此时指向下一个不同元素
            } else {//非重复元素
                record[j] = nums[i];
                j++;
                i++;
            }
        }
        if (j == 1) {
            record[j] = nums[nums.length - 1];
        }//最后一个元素可能没有算入
        return record;
    }
}