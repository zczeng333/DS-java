class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1, x;
        while (left < right) {
            x = numbers[left] + numbers[right];
            if (x == target) {
                return new int[]{left + 1, right + 1};
            } else if (x < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}