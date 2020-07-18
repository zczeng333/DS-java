class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length, sum = 2 * n + 3, square = 2 * n * n + 6 * n + 5;//sum存储缺失元素和, square存储缺失元素平方和
        for (int i = 0; i < n; i++) {
            sum = sum + i + 1 - nums[i];
            square = square + (i + 1) * (i + 1) - nums[i] * nums[i];
        }
        return new int[]{(int) (Math.sqrt(2 * square - sum * sum) + sum) / 2, (int) (sum - Math.sqrt(2 * square - sum * sum)) / 2};
    }
}