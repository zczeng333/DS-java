class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start, end, i = 0;
        ArrayList<int[]> list = new ArrayList<int[]>();
        while (i < intervals.length) {//直至倒数第二个元素
            start = intervals[i][0];//起始值
            end = intervals[i][1];//终止值
            while (i < intervals.length - 1 && intervals[i + 1][0] <= end) {//可以合并
                i++;
                end = Math.max(intervals[i][1], end);
            }//跳出对应的i要么超出范围，要么不可合并了
            list.add(new int[]{start, end});//合并后的数组
            i++;
        }
        int[][] array = list.toArray(new int[list.size()][2]);
        return array;
    }
}