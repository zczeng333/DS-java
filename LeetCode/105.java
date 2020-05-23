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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //基本思路：前序遍历用于给定相应子树的根节点，中序遍历用于划分左右子树
        //前序遍历[根,[左子树前序],[右子树前序]]
        //中序遍历[[左子树中序],根,[右子树中序]]
        if (preorder.length == 0) {
            return null;
        }//根节点
        TreeNode root = new TreeNode(preorder[0]);
        int pos = findpos(inorder, preorder[0]);//在inorder数组中寻找根节点位置的位置
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, pos + 1), Arrays.copyOfRange(inorder, 0, pos));//左子树
        root.right = buildTree(Arrays.copyOfRange(preorder, pos + 1, preorder.length), Arrays.copyOfRange(inorder, pos + 1, inorder.length));//右子树
        return root;
    }

    public int findpos(int[] array, int v) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == v) {
                break;
            }
        }
        return i;
    }
}