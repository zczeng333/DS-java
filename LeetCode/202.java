class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> record = new ArrayList<Integer>();
        record.add(n);
        int temp;
        while (true) {
            temp = update(n);
            if (temp == 1) {
                break;
            }
            if (record.contains(temp)) {
                return false;
            }
            record.add(temp);
            n = temp;
        }
        return true;
    }

    public int update(int n) {//计算n的各位平方和
        int sum = 0;
        while (n >= 1) {
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}