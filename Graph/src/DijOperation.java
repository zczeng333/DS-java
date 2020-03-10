public class DijOperation {
    private GraphNode[] out;
    private int MaxElement;

    public DijOperation(int MaxElement, int W[][]) {
        /**
         * @description
         * @param MaxElement
         * @param W
         * @return
         * @author zczeng
         * @date 2020/3/10 16:30
         */
        this.out = new GraphNode[MaxElement];
        this.MaxElement = MaxElement;
        for (int i = 0; i < MaxElement; i++) {/*Set up fake node for each graph list*/
            this.out[i] = new GraphNode(i);
        }
        for (int i = 0; i < MaxElement; i++) {
            for (int j = i; j < MaxElement; j++) {
                if (W[i][j] != 0) {/*from i to j*/
                    Add(this.out[i], j, W[i][j]);
                }
                if (W[j][i] != 0) {/*from j to i*/
                    Add(this.out[j], i, W[j][i]);
                }
            }
        }
    }

    private void Add(GraphNode N, int i, int dis) {/*add new node with index i to the tail of N*/
        while (N.next != null) {
            N = N.next;
        }
        N.next = new GraphNode(i);
        N.next.dis = dis;
    }

    public void Dijkstra(int start, int end) {
        /*record parent(1st col), current dis from start(2nd col) and judge whether has been visited(3rd col)*/
        double[][] record = new double[this.MaxElement][3];
        int i;
        double temp_dis;
        int index = start;
        GraphNode p;
        for (i = 0; i < this.MaxElement; i++) {
            record[i][0] = -1;
            record[i][1] = Double.POSITIVE_INFINITY;
        }
        record[start][1] = 0;
        while (index != -1) {/*guarantee all nodes have been visited*/
            p = this.out[index].next;
            record[index][2] = 1;/*1 indicate node index has been visited*/
            while (p != null) {/*visit all nodes linked to temp*/
                if (record[p.ind][1] > record[index][1] + p.dis) {/*relax dis of node p.ind*/
                    record[p.ind][1] = record[index][1] + p.dis;
                    record[p.ind][0] = index;
                }
                p = p.next;
            }
            index = -1;
            temp_dis = Double.POSITIVE_INFINITY;
            for (i = 0; i < this.MaxElement; i++) {
                if (record[i][2] == 0 && record[i][1] < temp_dis) {/*find the non-visited node with the smallest dis*/
                    temp_dis = record[i][1];
                    index = i;
                }
            }
        }
        if (record[end][2] == 0) {
            System.out.printf("No path between %d and %d", start, end);
        } else {
            System.out.printf("Shortest path between %d and %d: [", start, end);
            index = end;
            while (index != start) {
                System.out.printf("%d, ", index);
                index = (int) record[index][0];
            }
            System.out.printf("%d]", start);
        }
    }
}
