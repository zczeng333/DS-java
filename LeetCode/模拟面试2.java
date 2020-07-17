class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int[] sum = new int[A.length];//记录a[0]~a[i](含两端)的和
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();//记录和为integer的子数组的结尾位置
        sum[0] = A[0];
        map.put(sum[0], new ArrayList<Integer>());
        map.get(sum[0]).add(0);
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], new ArrayList<Integer>());
            }
            map.get(sum[i]).add(i);
        }
        int total = sum[A.length - 1];
        if (total % 3 != 0) {
            return false;
        }//total不能整除3，不能满足整数数组
        if (!map.containsKey(total / 3) || !map.containsKey(total * 2 / 3)) {
            return false;
        }//找不到等分子数组
        ArrayList<Integer> temp1 = (ArrayList<Integer>) map.get(total / 3);
        ArrayList<Integer> temp2 = (ArrayList<Integer>) map.get(total * 2 / 3);
        for (int i = 0; i < temp2.size(); i++) {
            if (temp2.get(i) > temp1.get(0) && temp2.get(i) < A.length - 1) {
                return true;
            }
        }
        return false;
    }
}