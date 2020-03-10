public class DisSetOperation {
    private DisSetNode[] s;
    private DisSetNode root;

    public DisSetOperation(int MaxElement) {
        /**
         * @description Initialization for Disjoint Set
         * @param MaxElement Max number of element
         * @return
         * @author zczeng
         * @date 2020/3/10 16:38
         */
        this.s = new DisSetNode[MaxElement + 1];
        this.root = new DisSetNode(null, 0);
        this.root.size = -1;
        for (int i = 1; i < MaxElement + 1; i++) {
            s[i] = new DisSetNode(root, i);
            this.root.size = this.root.size - 1;
        }
    }

    public void BuildSet(int[][] r) {
        /**
         * @description build up disjoint set based on relations
         * @param r relation array, each row of which is a relation
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:39
         */
        if (r.length == 0) {
            System.out.println("Empty relation!");
        } else {
            for (int i = 0; i < r.length; i++) {
                if (find(this.s[r[i][0]]) != find(this.s[r[i][1]])) {
                    union(this.s[r[i][0]], this.s[r[i][1]]);
                }
            }
            System.out.println("Set relation: " + "\n" + "n  p");
            for (int i = 1; i < this.s.length; i++) {
                System.out.printf("%d  %d" + "\n", this.s[i].index, this.s[i].parent.index);
            }
        }
    }

    private DisSetNode find(DisSetNode x) {
        /**
         * @description find the ancestor of node x in
         * @param x
         * @return DisSetNode
         * @author zczeng
         * @date 2020/3/10 16:40
         */
        while (x.parent != root) {
            x = x.parent;
        }
        return x;
    }

    private void union(DisSetNode x, DisSetNode y) {
        /**
         * @description Union node x with node y in a disjoint set
         * @param x
         * @param y
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:41
         */
        DisSetNode n1, n2;
        n1 = find(x);
        n2 = find(y);
        if (n1.size > n2.size) {
            n2.parent = x;
            while (x != root) {
                x.size = x.size + n2.size;
                x = x.parent;
            }
        } else {
            n1.parent = y;
            while (y != root) {
                y.size = y.size + n1.size;
                y = y.parent;
            }
        }
    }

    public void PrintSet() {
        /**
         * @description print disjoint set
         * @param
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:41
         */
        DisSetNode[] record = this.s;
        DisSetNode temp;
        for (int i = 1; i < record.length; i++) {
            temp = record[i];
            if (temp.parent == root) {
                continue;
            } else {
                while (temp.parent != root) {
                    temp = temp.parent;
                }
                record[i].parent = temp;
            }
        }
        for (int i = 1; i < record.length; i++) {
            System.out.printf("%d: %d" + "\n", record[i].index, record[i].parent.index);
        }
    }
}
