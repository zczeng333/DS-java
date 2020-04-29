//Solution1: 递归->超时
class Solution {
    public int waysToChange(int n) {
        if (n == 0) {
            return 0;
        }
        return countway(n, 25);
    }

    public int countway(int n, int maxv) {//利用最大值为maxv的面值来组合得到n
        if (n == 0) {
            return 1;
        }//没有组合方式
        int count = 1;//全为1的组合
        int temp;
        if (maxv >= 25 && n >= 25) {
            count = count + countway(n - 25, 25);
        }//用一个25
        if (maxv >= 10 && n >= 10) {
            count = count + countway(n - 10, 10);
        }//用一个25//用一个10
        if (maxv >= 5 && n >= 5) {
            count = count + countway(n - 5, 5);
        }//用一个25//用一个5
        return count % 1000000007;
    }
}

//Solution2: 动态规划
class Solution {
    private final int mod = 1000000007;
    private final int[] coins = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                res[i] = (res[i] + res[i - coin]) % mod;
            }
        }
        return res[n];
    }
}