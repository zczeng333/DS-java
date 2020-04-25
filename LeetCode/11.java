class Solution {
    public int maxArea(int[] height) {
        ArrayList<int[]> left = new ArrayList<int[]>();
        ArrayList<int[]> right = new ArrayList<int[]>();
        int i, j, max = 0;
        for (i = 0; i < height.length; i++) {
            if (height[i] > max) {
                left.add(new int[]{i, height[i]});
                max = height[i];
            }
        }
        max = 0;
        for (i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                right.add(new int[]{i, height[i]});
                max = height[i];
            }
        }
        max = 0;
        for (i = 0; i < left.size(); i++) {
            for (j = 0; j < right.size() && right.get(j)[0] > left.get(i)[0]; j++) {
                max = Math.max(max, (right.get(j)[0] - left.get(i)[0]) * Math.min(right.get(j)[1], left.get(i)[1]));
            }
        }
        return max;
    }
}