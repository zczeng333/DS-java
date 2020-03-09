public class GraphNode {
    public GraphNode next;
    public int ind;
    public int dis;

    public GraphNode(int ind) {
        this.ind = ind;
        this.next = null;
        this.dis = 0;
    }
}
