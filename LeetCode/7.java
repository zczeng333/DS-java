class Solution {
    public int reverse(int x) {
        int count = 0;
        while (x != 0) {
            if (count > Integer.MAX_VALUE / 10 || (count == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
                return 0;
            }
            if (count < Integer.MIN_VALUE / 10 || (count == Integer.MIN_VALUE / 10 && x % 10 < -8)) {
                return 0;
            }
            System.out.println(x % 10);
            count = 10 * count + x % 10;
            x = x / 10;
        }
        return count;
    }
}