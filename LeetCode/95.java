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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        List<TreeNode> tree = subtree(1, n);
        return tree;
    }

    public List<TreeNode> subtree(int start, int n) {//索引从start开始，长度为n的子树
        List<TreeNode> tree = new LinkedList<TreeNode>();//tree列表记录子树
        if (n == 0) {
            tree.add(null);
            return tree;
        }
        List<TreeNode> l, r;
        for (int i = 0; i < n; i++) {
            l = subtree(start, i);//左子树（所有元素小于根节点）
            r = subtree(start + i + 1, n - 1 - i);//右子树（所有元素大于根节点）
            for (int j = 0; j < l.size(); j++) {
                for (int k = 0; k < r.size(); k++) {
                    TreeNode root = new TreeNode(start + i);//根节点
                    root.left = l.get(j);
                    root.right = r.get(k);
                    tree.add(root);
                }
            }
        }
        return tree;
    }
}