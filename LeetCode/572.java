/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            if (isEqual(s, t)) {
                return true;
            }
        }
        if (s.left != null && isSubtree(s.left, t)) {
            return true;
        }
        if (s.right != null && isSubtree(s.right, t)) {
            return true;
        }
        return false;
    }

    public boolean isEqual(TreeNode s, TreeNode t) {//判断s为根的树和t为根的数是否相同
        if (s == null && t == null) {
            return true;
        }//根节点
        if ((s == null && t != null) || (s != null && t == null) || s.val != t.val) {
            return false;
        }//不相等
        return isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }
}