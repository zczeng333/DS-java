public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;

    public TreeNode(TreeNode left, TreeNode right, int value) {
        /**
         * @description node data structure for Tree
         * @param left left child of current node
         * @param right right child of current node
         * @param value key value of current node
         * @return
         * @author zczeng
         * @date 2020/3/5 23:13
         */
        this.left = left;
        this.right = right;
        this.value = value;
    }
}