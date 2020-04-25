//Solution 1: 超时
class Solution {
    public int trap(int[] height) {
        ArrayList record = new ArrayList();
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                record.add(i);
            }
        }
        return iter(height, record);
    }

    public int iter(int[] height, ArrayList record) {
        if (record.size() <= 1) {
            return 0;
        }//无法构成积水槽
        int min = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < record.size(); i++) {
            if (min < height[(int) record.get(i)]) {
                min = height[(int) record.get(i)];
            }
        }
        int count = (int) record.get(record.size() - 1) - (int) record.get(0) - record.size() + 1;
        for (i = 0; i < record.size(); i++) {
            height[(int) record.get(i)] = height[(int) record.get(i)] - min;
            if (height[(int) record.get(i)] == 0) {
                record.remove(i);
            }
        }
        return min * count + iter(height, record);
    }
}

//Solution 2: 475ms
class Solution {
    public int trap(int[] height) {
        ArrayList<Integer> record = new ArrayList<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                record.add(i);
            }
        }
        return iter(height, record);
    }

    public int iter(int[] height, ArrayList<Integer> record) {
        if (record.size() <= 1) {
            return 0;
        }//无法构成积水槽
        int min = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < record.size(); i++) {
            if (min > height[record.get(i)]) {
                min = height[record.get(i)];
            }
        }
        int count = record.get(record.size() - 1) - record.get(0) - record.size() + 1;
        for (i = 0; i < record.size(); i++) {
            height[record.get(i)] = height[record.get(i)] - min;
            if (height[record.get(i)] == 0) {
                record.remove(i);
                i--;
            }
        }
        return min * count + iter(height, record);
    }
}