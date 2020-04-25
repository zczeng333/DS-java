class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> record = new ArrayList();
        if (nums.length < 3) {
            return record;
        }
        Arrays.sort(nums);
        int i, j, k, sum;
        for (i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }//对排序后数组，不会再有sum=0的三元组
            while (i > 0 && i < nums.length - 2 && nums[i] == nums[i - 1]) {
                i++;
            }//防止重复结果
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    record.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return record;
    }
}