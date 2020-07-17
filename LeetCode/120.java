//Solution 1: 该方法只适用于没有负值的triangle
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[] temp;
        if (triangle.isEmpty() || triangle.get(0).isEmpty()) {
            return 0;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });//小顶堆，堆顶是当前sum最小的元素；元素int[3]为(sum,x,y)
        heap.offer(new int[]{triangle.get(0).get(0), 0, 0});//将三角顶元素放入小顶堆
        triangle.get(0).set(0, Integer.MAX_VALUE);//将元素标注为已访问(Integer.MAX_VALUE)
        while (true) {
            temp = (int[]) heap.poll();//获取小顶堆的堆顶元素
            if (temp[1] == height - 1) {
                break;
            }
            if (triangle.get(temp[1] + 1).get(temp[2]) != Integer.MAX_VALUE) {//左元素
                heap.offer(new int[]{temp[0] + triangle.get(temp[1] + 1).get(temp[2]), temp[1] + 1, temp[2]});
                triangle.get(temp[1] + 1).set(temp[2], Integer.MAX_VALUE);
            }
            if (triangle.get(temp[1] + 1).get(temp[2] + 1) != Integer.MAX_VALUE) {//右元素
                heap.offer(new int[]{temp[0] + triangle.get(temp[1] + 1).get(temp[2] + 1), temp[1] + 1, temp[2] + 1});
                triangle.get(temp[1] + 1).set(temp[2] + 1, Integer.MAX_VALUE);
            }
        }
        return temp[0];
    }
}

//Solution 2: 动态规划，从底部叶节点开始回溯到根节点，适用于负值cost
class Solution {
    public int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        dp = new int[height][height];//动态规划数组，用于记录由root到每个节点的最短路径长
        for (int i = 0; i < height; i++) {
            dp[height - 1][i] = triangle.get(height - 1).get(i);
        }
        for (int i = height - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--)
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        }
        return dp[0][0];
    }
}