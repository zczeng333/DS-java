import java.util.Arrays;

public class Graph {
    public static void main(String[] args) {
        topsort();
        bfs(2, 4);
    }

    private static void topsort() {
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
}
