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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return judge(root.left, (long) Integer.MIN_VALUE - 1, root.val) && judge(root.right, root.val, (long) Integer.MAX_VALUE + 1);
    }

    public boolean judge(TreeNode p, long min, long max) {//判断节点p是否合理
        if (p == null) {
            return true;
        }
        if (p.val <= min || p.val >= max) {
            return false;
        }
        if (p.right != null && !judge(p.right, Math.max(min, p.val), max)) {
            return false;
        }
        if (p.left != null && !judge(p.left, min, Math.min(max, p.val))) {
            return false;
        }
        return true;
    }
}