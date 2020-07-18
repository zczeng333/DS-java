class Solution {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}

class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] record = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (record[nums[i]] != 0) {
                return nums[i];
            } else {
                record[nums[i]] = 1;
            }
        }
        return 0;
    }
}