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
    public ArrayList<List<Integer>> record;

    public List<List<Integer>> levelOrder(TreeNode root) {
        record = new ArrayList<List<Integer>>();
        if (root == null) {
            return record;
        }
        search(root, 0);
        return record;
    }

    public void search(TreeNode root, int depth) {//root为当前子树的根节点，depth为根节点的深度
        if (record.size() < depth + 1) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(root.val);
            record.add(temp);
        } else {
            record.get(depth).add(root.val);
        }
        if (root.left != null) {
            search(root.left, depth + 1);
        }
        if (root.right != null) {
            search(root.right, depth + 1);
        }
    }
}