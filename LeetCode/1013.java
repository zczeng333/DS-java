class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0, temp_sum = 0, flag = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum = sum / 3;
        for (int i = 0; i < A.length; i++) {
            temp_sum = temp_sum + A[i];
            if (temp_sum == sum) {
                temp_sum = 0;
                flag++;
            }
        }
        if ((sum == 0 && flag >= 3) || flag == 3) {
            return true;
        }
        return false;
    }
}