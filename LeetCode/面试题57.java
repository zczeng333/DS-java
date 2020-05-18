class Solution {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> record = new ArrayList<int[]>();
        int i = 2;
        int[] temp;
        while (true) {//可能存在连续正整数序列
            if (i % 2 == 0) {//偶数，target不能整除i
                if (target / i - i / 2 + 1 <= 0) {
                    break;
                }
                if ((target - 0.5 * i) % i == 0) {
                    temp = new int[i];
                    for (int j = 0; j < i; j++) {
                        temp[j] = target / i - i / 2 + 1 + j;
                    }
                    record.add(0, temp);
                }
            } else {//奇数，target必须整除i
                if (target / i - i / 2 <= 0) {
                    break;
                }
                if (target % i == 0) {
                    temp = new int[i];
                    for (int j = 0; j < i; j++) {
                        temp[j] = target / i - i / 2 + j;
                    }
                    record.add(0, temp);
                }
            }
            i++;
        }
        return record.toArray(new int[0][]);
    }
}