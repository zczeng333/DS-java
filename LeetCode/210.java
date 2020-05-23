class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> out = new LinkedList<Integer>();//栈记录in-degree=0的节点
        int pre, post, temp, i;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//hash表，key为课程名，value为对应课程节点的in-degree
        int[] order = new int[numCourses];//修课顺序（图的拓扑排序）
        while (graph.size() < numCourses) {//建立图的连接关系
            graph.add(new ArrayList<Integer>());
        }
        for (i = 0; i < prerequisites.length; i++) {//建图,graph.get(i)存储了课程i的所有后继（需要i作为先修课的课程）
            pre = prerequisites[i][1];//先修课
            post = prerequisites[i][0];//后继课
            graph.get(pre).add(post);//将后继课放入到先修课的链表中
            if (map.containsKey(post)) {//当hashmap中已经有后继课程时
                map.put(post, map.get(post) + 1);
            } else {//首次出现，将对应节点值置为1
                map.put(post, 1);
            }
        }
        for (i = 0; i < numCourses; i++) {//寻找所有初始in-degree=0的节点入栈
            if (!map.containsKey(i)) {
                out.offer(i);
            }
        }
        i = 0;
        while (out.size() != 0) {
            order[i] = out.poll();
            for (int j = 0; j < graph.get(order[i]).size(); j++) {
                post = graph.get(order[i]).get(j);
                map.put(post, map.get(post) - 1);
                if (map.get(post) == 0) {
                    out.offer(post);
                }
            }
            i++;
        }
        if (i < numCourses - 1) {
            return new int[0];
        }
        ;
        return order;
    }
}