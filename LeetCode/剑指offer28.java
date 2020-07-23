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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode A, TreeNode B) {//判断A和B两棵树是否是镜像对称的
        if (A == null && B == null) {
            return true;
        }//两棵树均为空
        if (A == null || B == null) {
            return false;
        }//只有一棵树为空
        if (A.val != B.val) {
            return false;
        }
        return isEqual(A.left, B.right) && isEqual(A.right, B.left);//比较A的左(右)子树与B的右(左)子树是否镜像
    }
}