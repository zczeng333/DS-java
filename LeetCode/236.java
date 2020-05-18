/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<Integer> path_p = path(root, p);
        ArrayList<Integer> path_q = path(root, q);
        TreeNode temp = root;
        int i = path_p.size() - 1, j = path_q.size() - 1;
        while (i >= 0 && j >= 0 && path_p.get(i) == path_q.get(j)) {
            if (path_p.get(i) == 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
            i--;
            j--;
        }
        return temp;
    }

    public ArrayList<Integer> path(TreeNode root, TreeNode target) {//dfs寻找target节点，并返回由root到target的path(0表示left，1表示right)
        ArrayList<Integer> record = new ArrayList<Integer>();
        if (root == target) {
            return record;
        }
        if (root == null) {
            return null;
        }
        record = path(root.left, target);
        if (record != null) {//在左子树
            record.add(0);//left
            return record;
        }
        //不在左子树
        record = path(root.right, target);
        if (record != null) {//在右子树
            record.add(1);//right
            return record;
        }
        return null;
    }
}