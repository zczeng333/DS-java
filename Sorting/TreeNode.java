/**
 * @description Tree node class
 * @author zczeng
 * @date 2020/2/28 10:04
 */
public class TreeNode {
    public TreeNode(TreeNode parent, TreeNode left, TreeNode right, int value) {
        /**
         * @description node for binary search tree
         * @param parent parent of the node
         * @param left left child of the node
         * @param right right child of the node
         * @param value value of the node
         * @return
         * @author zczeng
         * @date 2020/2/27 21:32
         */
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    public int value;
}