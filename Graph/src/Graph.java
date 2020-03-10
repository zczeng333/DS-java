import java.util.Arrays;

public class Graph {
    public static void main(String[] args) {
        /**
         * test for graph
         * */
        topsort();
        System.out.println();
        bfs(2, 4);
        System.out.println();
        dij(0, 5);
        System.out.println();
    }

    private static void topsort() {
        /**
         * @description test for topological sort for graph
         * @param
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:28
         */
        int MaxElement = 7;
        int[][] A = new int[][]{{0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 1, 1}, {0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0}};
        System.out.println("Adjacent Matrix: ");
        for (int j = 0; j < MaxElement; j++) {
            System.out.println(Arrays.toString(A[j]));
        }
        GraphOperation G = new GraphOperation(MaxElement, A);
        System.out.print("Topological Sort: ");
        int[] result = G.TopSort();
        if (result != null) {
            System.out.println(Arrays.toString(result));
        }
    }

    private static void bfs(int start, int end) {
        /**
         * @description test for breadth first search
         * @param start index of start node
         * @param end index of end node
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:28
         */
        int MaxElement = 7;
        int[][] A = new int[][]{{0, 1, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0}};
        System.out.println("Adjacent Matrix: ");
        for (int j = 0; j < MaxElement; j++) {
            System.out.println(Arrays.toString(A[j]));
        }
        GraphOperation G = new GraphOperation(MaxElement, A);
        int[] path = G.bfs(start, end);
        if (path == null) {
            System.out.printf("No path between %d and %d" + "\n", start, end);
        } else {
            System.out.printf("Path between %d and %d: ", start, end);
            System.out.println(Arrays.toString(path));
        }
    }

    private static void dij(int start, int end) {
        /**
         * @description test for Dijkstra algorithm
         * @param start index of start node
         * @param end index of end node
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:29
         */
        int MaxElement = 7;
        int[][] A = new int[][]{{0, 2, 0, 1, 0, 0, 0}, {0, 0, 0, 3, 10, 0, 0}, {4, 0, 0, 0, 0, 5, 0}, {0, 0, 2, 0, 2, 8, 4}, {0, 0, 0, 0, 0, 0, 6}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0}};
        System.out.println("Weight Matrix: ");
        for (int j = 0; j < MaxElement; j++) {
            System.out.println(Arrays.toString(A[j]));
        }
        DijOperation G = new DijOperation(MaxElement, A);
        G.Dijkstra(start, end);
    }
}
