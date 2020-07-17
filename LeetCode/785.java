class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] record = new int[graph.length];//record用于记录node所属group，0表示未遍历，1/2表示group，3表示孤立节点
        Queue q = new LinkedList<int[]>();
        int start = 0;
        int[] temp = new int[2];
        while (start < graph.length) {
            while (start < graph.length && record[start] != 0) {
                start++;
            }//寻找到第一个没有遍历到的节点
            if (start == graph.length) {
                break;
            }
            if (graph[start].length == 0) {
                q.offer(new int[]{start, 3});
                record[start] = 3;
            }//孤立节点
            else {
                q.offer(new int[]{start, 1});
                record[start] = 1;
            }
            while (q.size() != 0) {
                temp = (int[]) q.poll();
                for (int i = 0; i < graph[temp[0]].length; i++) {
                    if (record[graph[temp[0]][i]] == 0) {
                        record[graph[temp[0]][i]] = 3 - temp[1];
                        q.offer(new int[]{graph[temp[0]][i], 3 - temp[1]});
                    } else if (record[graph[temp[0]][i]] + temp[1] != 3) {
                        return false;
                    }//分组矛盾
                }
            }
        }
        return true;
    }
}