public class MazeOperation {
    private int[][] maze;/*record maze, 0->accessible, 1->barrier*/
    private int[][] record;/*record whether the block has been visited, 0->not visited, 1->visited*/
    private int x_len;
    private int y_len;
    private int[] start;
    private int[] end;
    private StackOperation stack;/*use stack to record the path*/

    public MazeOperation(int[][] array, int[] s, int[] e) {
        /**
         * @description Operation for maze
         * @param array maze
         * @param s start position
         * @param e end position
         * @return
         * @author zczeng
         * @date 2020/3/10 16:22
         */
        this.maze = array;
        this.record = array;
        this.x_len = this.maze.length;
        this.y_len = this.maze[0].length;
        this.start = s;
        this.end = e;
        this.stack = new StackOperation();
    }

    private int FindPath(int[] pos) {
        /**
         * @description find path from pos to end
         * @param pos starting position
         * @return int 0->did not find the path currently, 1->find the path
         * @author zczeng
         * @date 2020/3/10 16:22
         */
        this.record[pos[0]][pos[1]] = 1;/*record the position has been visited*/
        int judge = 0;
        if (pos[0] == this.end[0] && pos[1] == this.end[1]) {
            this.stack.push(pos);
            judge = 1;
        } else {
            if (pos[0] - 1 >= 0 && this.maze[pos[0] - 1][pos[1]] == 0 && this.record[pos[0] - 1][pos[1]] == 0) {/*up*/
                judge = FindPath(new int[]{pos[0] - 1, pos[1]});
                if (judge == 1) {/*this path has reached the end point*/
                    this.stack.push(pos);
                    return judge;
                }
            }
            if (pos[0] + 1 < this.x_len && this.maze[pos[0] + 1][pos[1]] == 0 && this.record[pos[0] + 1][pos[1]] == 0) {/*down*/
                judge = FindPath(new int[]{pos[0] + 1, pos[1]});
                if (judge == 1) {
                    this.stack.push(pos);
                    return judge;
                }
            }
            if (pos[1] - 1 >= 0 && this.maze[pos[0]][pos[1] - 1] == 0 && this.record[pos[0]][pos[1] - 1] == 0) {/*left*/
                judge = FindPath(new int[]{pos[0], pos[1] - 1});
                if (judge == 1) {
                    this.stack.push(pos);
                    return judge;
                }
            }
            if (pos[1] + 1 < this.y_len && this.maze[pos[0]][pos[1] + 1] == 0 && this.record[pos[0]][pos[1] + 1] == 0) {/*up*/
                judge = FindPath(new int[]{pos[0], pos[1] + 1});
                if (judge == 1) {
                    this.stack.push(pos);
                    return judge;
                }
            }
            if (judge == 0 && pos == this.start) {
                System.out.println("No Path found");
            }
        }
        return judge;
    }

    public StackOperation GetPath() {
        FindPath(this.start);
        return this.stack;
    }
}
