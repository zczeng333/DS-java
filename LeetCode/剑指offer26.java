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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        if (isEqual(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)) {
            return true;
        }
        return false;
    }

    public boolean isEqual(TreeNode A, TreeNode B) {//判断A和B是否是相同树结构
        if (B == null) {
            return true;
        }//两个均为空指针
        if (A == null) {
            return false;
        }//一个为空指针
        if (A.val != B.val) {
            return false;
        }//两个指针值不同
        return isEqual(A.left, B.left) && isEqual(A.right, B.right);//继续递归判断是否是相同树
    }
}