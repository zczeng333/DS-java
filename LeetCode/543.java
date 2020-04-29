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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode p) {
        int left = 0, right = 0;//记录左右子树的边数，包括根节点
        if (p.left == null && p.right == null) {//叶节点
            return 0;
        }
        if (p.left != null) {
            left = 1 + dfs(p.left);
        }
        if (p.right != null) {
            right = 1 + dfs(p.right);
        }
        if (max < left + right) {
            max = left + right;
        }
        return Math.max(left, right);
    }
}