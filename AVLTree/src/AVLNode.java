public class AVLNode {
    public AVLNode left;
    public AVLNode right;
    public AVLNode parent;
    public int key;
    public int height;

    public AVLNode(int k) {
        this.key=k;
        this.height = CalHeight();
    }

    private int CalHeight() {
        int l = AVLOperation.GetHeight(this.left);
        int r = AVLOperation.GetHeight(this.right);
        return l > r ? (l + 1) : (r + 1);
    }
}
