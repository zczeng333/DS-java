class Solution {
    public int minArray(int[] numbers) {
        int mid, left = 0, right = numbers.length - 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        mid = (left + right) / 2;
        return numbers[mid];
    }
}