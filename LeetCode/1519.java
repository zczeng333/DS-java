//Solution 1:先依据edges建立父子关系，之后从根节点开始递归遍历整棵树（LinkedList超时）
class Solution {
    public int[][] dp;//动态规划数组，dp[i][j]表示节点i的子树中包含字母'a'+j的个数
    public int[] record;//记录元素是否被访问过
    public LinkedList<LinkedList<Integer>> l;//将edges转化为二维链表，list[i]记录节点i子树中不同字母的频次
    public String str;
    public int[] answer;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        dp = new int[n][26];
        record = new int[n];
        l = new LinkedList<LinkedList<Integer>>();
        str = labels;
        for (int i = 0; i < n; i++) {
            l.add(new LinkedList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            l.get(edges[i][0]).add(edges[i][1]);
            l.get(edges[i][1]).add(edges[i][0]);
        }
        answer = new int[n];
        count(0);
        return answer;
    }

    public void count(int ind) {//获取ind为根节点的子树数据
        LinkedList<Integer> child = l.get(ind);//获取ind节点的子节点
        int[] sum = new int[26];
        int[] temp;
        record[ind] = -1;
        sum[(int) (str.charAt(ind) - 'a')] = 1;
        for (int i = 0; i < child.size(); i++) {
            if (record[child.get(i)] == 0) {
                count(child.get(i));
                temp = dp[child.get(i)];
                for (int j = 0; j < 26; j++) {
                    sum[j] = sum[j] + temp[j];
                }
            }
        }
        dp[ind] = sum;
        answer[ind] = sum[(int) (str.charAt(ind) - 'a')];
    }
}

//Solution 2:使用TreeSet记录节点（忽略父子关系的判别，在之后的DFS访问中自然会呈现出父子关系）
class Solution {
    public int[][] dp;//动态规划数组，dp[i][j]表示节点i的子树中包含字母'a'+j的个数
    public int[] record;//记录元素是否被访问过
    public TreeSet<Integer>[] l;//将edges转化为二维链表，list[i]记录节点i子树中不同字母的频次
    public String str;
    public int[] answer;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        dp = new int[n][26];
        record = new int[n];
        l = new TreeSet[n];
        str = labels;
        for (int i = 0; i < n; i++) {
            l[i] = new TreeSet<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            l[edges[i][0]].add(edges[i][1]);
            l[edges[i][1]].add(edges[i][0]);
        }
        answer = new int[n];
        count(0);
        return answer;
    }

    public void count(int ind) {//获取ind为根节点的子树数据
        int[] sum = new int[26];
        int[] temp;
        record[ind] = -1;
        sum[(int) (str.charAt(ind) - 'a')] = 1;
        for (int i : l[ind]) {
            if (record[i] == 0) {
                count(i);
                temp = dp[i];
                for (int j = 0; j < 26; j++) {
                    sum[j] = sum[j] + temp[j];
                }
            }
        }
        dp[ind] = sum;
        answer[ind] = sum[(int) (str.charAt(ind) - 'a')];
    }
}