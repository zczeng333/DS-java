class Solution {
    public int[] val;
    public int[][] dp;

    public int maxCoins(int[] nums) {
        int[] flag = new int[nums.length + 2];//flag用于记录元素是否被访问过
        val = new int[nums.length + 2];
        //val记录nums的值,val[0]与val[n+1]表示边界,遍历过的元素标注为-1
        dp = new int[nums.length + 2][nums.length + 2];
        //dp[i][j]表示(i,j)内的最大硬币值,0和n+1为超出界限的值=1;其余的dp[n+1]对应nums[n]
        flag[0] = -1;//最左元素标注为访问
        flag[flag.length - 1] = -1;//最右元素标注为访问
        val[0] = 1;
        val[val.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            val[i + 1] = nums[i];
        }
        return findMax(0, val.length - 1, flag);
    }

    public int findMax(int left, int right, int[] flag) {//寻找开区间(left,right)中的最大硬币值
        if (left >= right - 1) {
            return 0;
        }//无效区间范围
        if (dp[left][right] != 0) {
            return dp[left][right];
        }//之前已经遍历过
        int max = 0, temp, j;
        for (int i = left + 1; i < right; i++) {
            if (flag[i] == 0) {//该元素未被访问过
                j = i - 1;
                temp = val[i];
                while (flag[j] == 0) {
                    j--;
                }//寻找左边的元素
                temp = temp * val[j];
                j = i + 1;
                while (flag[j] == 0) {
                    j++;
                }//寻找右边的元素
                temp = temp * val[j];
                flag[i] = -1;//之后的递归中这个元素被访问了
                temp = temp + findMax(left, i, flag) + findMax(i, right, flag);
                flag[i] = 0;//把flag对应位清零，不影响其他分支下的递归
                if (temp > max) {
                    max = temp;
                }
            }
        }
        dp[left][right] = max;
        return max;
    }
}