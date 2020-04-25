/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//Solution1: 2ms
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> record = new ArrayList<Integer>();
        if (root == null) {
            return record;
        }
        ArrayList<TreeNode> frontier = new ArrayList<TreeNode>();//记录前一层的所有节点
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();//记录后一层的所有节点
        TreeNode temp;
        int rightelement = 0;//记录某一层最右方的元素
        //广度优先搜索(从左至右)
        frontier.add(root);
        while (frontier.size() != 0) {
            next.clear();//清空下一层记录数组
            for (int i = 0; i < frontier.size(); i++) {
                temp = frontier.get(i);
                rightelement = temp.val;
                if (temp.left != null) {
                    next.add(temp.left);
                }
                if (temp.right != null) {
                    next.add(temp.right);
                }
            }
            record.add(rightelement);
            frontier = (ArrayList<TreeNode>) next.clone();
        }
        return record;
    }
}

//Solution2: 1ms 97.39%
class Solution {//堆栈

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> record = new ArrayList<Integer>();
        if (root == null) {
            return record;
        }
        Queue<TreeNode> frontier = new LinkedList<TreeNode>();
        TreeNode temp;
        int len, rightelement = 0;
        frontier.add(root);
        while (frontier.size() > 0) {
            len = frontier.size();
            for (int i = 0; i < len; i++) {
                temp = frontier.remove();
                rightelement = temp.val;
                if (temp.left != null) {
                    frontier.add(temp.left);
                }
                if (temp.right != null) {
                    frontier.add(temp.right);
                }
            }
            record.add(rightelement);
        }
        return record;
    }
}