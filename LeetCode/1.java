//Solution 1: 超出内存限制
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i, j, temp;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int[] record = new int[max - min + 1];
        target = target - 2 * min;
        for (i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min;//全部转化为非负数
            record[nums[i]]++;//对应数值出现的次数
        }
        for (i = 0; i < nums.length; i++) {
            record[nums[i]]--;//不能使用重复元素
            temp = target - nums[i];
            if (temp >= 0 && temp <= max - min && record[temp] != 0) {
                break;
            }
            record[nums[i]]++;
        }
        for (j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                break;
            }
        }
        return new int[]{i, j};
    }
}

//Solution 2: 115ms
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length - 1; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{i, j};
    }
}

//Solution 3
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.containsKey(target - nums[i]) && map.get((target - nums[i])) != i) {
                return new int[]{i, map.get((target - nums[i]))};
            }
        }
        return null;
    }
}