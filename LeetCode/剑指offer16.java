//Solution 1: 动态规划，不能使用数组(空间复杂度太高)，应使用HashMap
class Solution {
    public HashMap<Integer, Double> dp;

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        dp = new HashMap<Integer, Double>();//dp用于记录不同指数下的值
        dp.put(0, 1.0);
        dp.put(1, x);
        if (n > 0) {
            return x * cal(x, n - 1);
        } else {
            return 1.0 / (x * cal(x, -n - 1));
        }
    }

    public double cal(double x, int n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int i = n / 2;
        dp.put(n, cal(x, i) * cal(x, n - i));
        return dp.get(n);
    }
}