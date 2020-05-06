//递归，超时
class Solution {
    int[] expire = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        Arrays.sort(days);
        return MinCost(days, costs, 0);
    }

    public int MinCost(int[] days, int[] costs, int start) {//start记录仍为覆盖到的天数的元素索引
        if (start == days.length) {
            return 0;
        }//所有日期全部覆盖完成
        int min = Integer.MAX_VALUE, j = start;
        for (int i = 0; i < costs.length; i++) {
            while (j < days.length && days[j] < days[start] + expire[i]) {
                j++;
            }//找到下一个无法覆盖的索引
            min = Math.min(min, costs[i] + MinCost(days, costs, j));
        }
        return min;
    }
}

//动态规划，2ms(43.75%)
class Solution {
    int[] expire = new int[]{1, 7, 30};
    int[] dp;//dp[i]表示排序后days[i]~days[-1]所需的最少费用

    public int mincostTickets(int[] days, int[] costs) {
        Arrays.sort(days);
        int min, temp_i;
        dp = new int[days.length];
        dp[dp.length - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            dp[dp.length - 1] = Math.min(dp[dp.length - 1], costs[i]);
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            min = Integer.MAX_VALUE;
            temp_i = i + 1;
            for (int j = 0; j < costs.length; j++) {
                while (temp_i < days.length && days[temp_i] < days[i] + expire[j]) {
                    temp_i++;
                }//找到第一个无法覆盖日期
                if (temp_i == days.length) {
                    min = Math.min(costs[j], min);
                }//能全部覆盖
                else {
                    min = Math.min(min, costs[j] + dp[temp_i]);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }
}