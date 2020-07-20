public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        if (n < 0) {
            n = (int) Math.pow(2, 32) + n + 1;
            count = 1;//补码的符号位
        }//取负数的补码
        while (n >= 1) {
            count = count + n % 2;
            n = n / 2;
        }
        return count;
    }
}