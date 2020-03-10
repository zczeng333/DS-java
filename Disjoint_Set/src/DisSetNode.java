public class DisSetNode {
    public DisSetNode parent;
    public int index;
    public int size;

    public DisSetNode(DisSetNode p, int ind) {
        /**
         * @description Node for disjoint set
         * @param p parent of the node
         * @param ind index of the node
         * @return
         * @author zczeng
         * @date 2020/3/10 16:41
         */
        this.parent = p;
        this.index = ind;
        this.size = 1;
    }
}
