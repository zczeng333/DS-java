import java.util.Arrays;

public class GraphOperation {
    private GraphNode[] in;
    private GraphNode[] out;
    private int[] InDegree;
    private int[] OutDegree;
    private int MaxElement;

    public GraphOperation(int MaxElement, int[][] A) {
        /**
         * @description Initialization for graph
         * @param MaxElement Max number of element
         * @param A Adjacent matrix for graph
         * @return
         * @author zczeng
         * @date 2020/3/10 16:35
         */
        this.in = new GraphNode[MaxElement];
        this.out = new GraphNode[MaxElement];
        this.InDegree = new int[MaxElement];
        this.OutDegree = new int[MaxElement];
        this.MaxElement = MaxElement;
        for (int i = 0; i < MaxElement; i++) {/*Set up fake node for each graph list*/
            this.in[i] = new GraphNode(i);
            this.out[i] = new GraphNode(i);
        }
        for (int i = 0; i < MaxElement; i++) {
            for (int j = i; j < MaxElement; j++) {
                if (A[i][j] == 1) {/*from i to j*/
                    Add(this.out[i], j);
                    Add(this.in[j], i);
                    this.OutDegree[i] = this.OutDegree[i] + 1;
                    this.InDegree[j] = this.InDegree[j] + 1;
                }
                if (A[j][i] == 1) {/*from j to i*/
                    Add(this.out[j], i);
                    Add(this.in[i], j);
                    this.OutDegree[j] = this.OutDegree[j] + 1;
                    this.InDegree[i] = this.InDegree[i] + 1;
                }
            }
        }
        //System.out.println();
        //System.out.println(Arrays.toString(this.OutDegree));
        //System.out.println(Arrays.toString(this.InDegree));
    }

    private void Add(GraphNode N, int i) {
        /**
         * @description add new node with index i to the tail of N
         * @param N GraphNode to be added
         * @param i index of GraphNode
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:35
         */
        while (N.next != null) {
            N = N.next;
        }
        N.next = new GraphNode(i);
    }

    public int[] TopSort() {
        /**
         * @description find topological sorting order of the graph
         * @param
         * @return int[] graph in topological sorting order
         * @author zczeng
         * @date 2020/3/10 16:36
         */
        int[] result = new int[this.MaxElement];
        int[] d = this.InDegree;
        int judge;
        GraphNode temp;
        for (int i = 0; i < this.MaxElement; i++) {
            judge = 0;
            for (int j = 0; j < this.MaxElement; j++) {
                if (d[j] == 0) {
                    judge = 1;
                    result[i] = j;
                    d[j] = -1;
                    temp = this.out[j].next;
                    while (temp != null) {
                        d[temp.ind] = d[temp.ind] - 1;
                        temp = temp.next;
                    }
                    break;
                }
            }
            if (judge == 0) {
                System.out.println("Graph has a circle");
                return null;
            }
        }
        return result;
    }

    public int[] bfs(int start, int end) {
        /**
         * @description breadth first search
         * @param start index of start node
         * @param end index of end node
         * @return int[] path from start to end
         * @author zczeng
         * @date 2020/3/10 16:37
         */
        Queue q = new Queue();
        int[][] record = new int[this.MaxElement][2];/*record parent(1 col) & dis(2 col) of each node*/
        int i;
        int parent;
        int len;
        for (i = 0; i < this.MaxElement; i++) {
            record[i][0] = -1;
            record[i][1] = -1;
        }
        GraphNode node;
        GraphNode temp = this.out[start];
        record[start][0] = -2;
        record[start][1] = 0;
        q.enqueue(new QueueNode(start));
        while (!q.IsEmpty()) {
            parent = q.dequeue().ind;
            node = this.out[parent];
            temp = node;
            while (temp.next != null) {
                len = record[parent][1] + 1;
                if (record[temp.next.ind][0] == -1) {/*node hasn't been visited yet*/
                    q.enqueue(new QueueNode(temp.next.ind));
                    record[temp.next.ind][0] = parent;
                    record[temp.next.ind][1] = len;
                }
                temp = temp.next;
            }
        }
        if (record[end][0] == -1) {/*end node hasn't been visited, no path*/
            return null;
        } else {
            int[] result = new int[record[end][1] + 1];
            int index = end;
            for (i = result.length - 1; i >= 0; i--) {
                result[i] = index;
                index = record[index][0];
            }
            return result;
        }
    }
}
