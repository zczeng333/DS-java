public class BstNode {
    public BstNode(BstNode parent, BstNode left, BstNode right, int value) {
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

    public BstNode parent;
    public BstNode left;
    public BstNode right;
    public int value;
}
