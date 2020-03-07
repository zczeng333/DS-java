public class DisSetNode {
    public DisSetNode parent;
    public int index;
    public int size;

    public DisSetNode(DisSetNode p, int ind) {
        this.parent = p;
        this.index = ind;
        this.size = 1;
    }
}
