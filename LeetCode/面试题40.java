class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] nums = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }
}