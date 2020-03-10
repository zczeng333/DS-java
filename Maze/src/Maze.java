import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        /**
        * test for maze
        * */
        int size = 10;
        double ratio = 0.3;/*# barrier/# total size*/
        int[] start = new int[]{0, 0};
        int[] end = new int[]{size - 1, size - 1};
        int[][] maze = new int[size][size];
        int i, x, y;
        for (i = 0; i < ratio * size * size; i++) {
            x = (int) (Math.random() * size);
            y = (int) (Math.random() * size);
            if (maze[x][y] == 1) {
                i = i - 1;
                continue;
            }
            maze[x][y] = 1;
        }
        maze[start[0]][start[1]] = 0;
        maze[end[0]][end[1]] = 0;
        System.out.println("Maze: ");
        for (i = 0; i < size; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }
        MazeOperation M = new MazeOperation(maze, start, end);
        System.out.printf("Path from " + Arrays.toString(start) + " to " + Arrays.toString(end) + "\n");
        StackOperation path = M.GetPath();
        path.dispose();
    }
}
