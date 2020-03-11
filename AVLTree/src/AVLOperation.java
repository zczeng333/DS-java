public class AVLOperation {
    public AVLNode root;

    public AVLOperation(int[] args) {
        build_avl(args);
    }

    private void build_avl(int[] args) {
        if (args.length > 0) {
            AVLNode node;
            AVLNode temp = null;
            for (int i = 0; i < args.length; i++) {
                node = new AVLNode(args[i]);
                insert(node);
                temp = node;
            }
        }
    }

    public AVLNode Find(int k) {
        AVLNode temp = this.root;
        if (this.root == null) {
            System.out.println("Empty Tree");
            return null;
        }
        while (k != temp.key) {
            if (k < temp.key) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
            if (temp == null) {
                System.out.printf("AVL Tree does not have node with key %d" + "\n", k);
                return null;
            }
        }
        return temp;
    }

    public void insert(AVLNode node) {
        if (this.root == null) {/*empty tree*/
            this.root = node;
        } else {
            AVLNode temp = this.root;
            while (true) {
                if (temp.key > node.key) {
                    if (temp.left == null) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    }
                    temp = temp.right;
                }
            }
            UpdateHeight(node);
            Check_insert(node);
        }
    }

    //public void delete(AVLNode node) {
    //    if (node != null) {
    //        AVLNode record; /*record where Check_delete should start from*/
    //        if (node.left == null && node.right == null) {/*the node is a leave*/
    //            if (node.parent == null) {  /*root*/
    //                this.root = null;
    //                return;
    //            } else if (node.parent.left == node) {  /*node is on the left branch*/
    //                node.parent.left = null;
    //                record=node.parent;
    //                UpdateHeight(node.parent);
    //            } else {    /*node is on the right branch*/
    //                node.parent.right = null;
    //                record=node.parent;
    //                UpdateHeight(node.parent);
    //            }
    //        } else if (node.left == null && node.right != null) {   /*the node only has right branch*/
    //            if (node.parent == null) {  /*root*/
    //                this.root = node.right;   /*top becomes the right child*/
    //                node.right.parent = null;   /*set right child as root*/
    //                record=this.root;
    //            } else if (node.parent.left == node) {  /*node is on the left branch*/
    //                node.parent.left = node.right;
    //                node.right.parent = node.parent;
    //                UpdateHeight(node.parent);
    //            } else {    /*node is on the right branch*/
    //                node.parent.right = node.right;
    //                node.right.parent = node.parent;
    //                UpdateHeight(node.parent);
    //            }
    //            node.left = null;
    //            node.right = null;
    //            node.parent = null;
    //        } else if (node.left != null && node.right == null) {   /*the node only has left branch*/
    //            if (node.parent == null) {/*root*/
    //                this.root = node.left;
    //                node.left.parent = null;
    //            } else if (node.parent.left == node) {  /*node is on the left branch*/
    //                node.parent.left = node.left;
    //                node.left.parent = node.parent;
    //                UpdateHeight(node.parent);
    //            } else {/*node is on the right branch*/
    //                node.parent.right = node.left;
    //                node.left.parent = node.parent;
    //                UpdateHeight(node.parent);
    //            }
    //        } else if (node.left != null && node.right != null) {   /*have both left and right branches*/
    //            AVLNode pointer = node.right;  /*find the biggest value in the right branch*/
    //            while (pointer.left != null) {  /*find the most left child of node.right*/
    //                pointer = pointer.left;
    //            }
    //            if (pointer.right != null) {
    //                pointer.right.parent = pointer.parent;
    //            }
    //            /*
    //             * This is super tricky, cause you can't guarantee that pointer is on the left branch of its parent
    //             * (when pointer=node.right, pointer.left=pointer.right=null)
    //             * */
    //            if (pointer.parent.left == pointer) {
    //                pointer.parent.left = pointer.right;
    //            } else {
    //                pointer.parent.right = pointer.right;
    //            }
    //            node.key = pointer.key;
    //            UpdateHeight(pointer.parent);
    //        }
    //        Check_delete();
    //    }
    //}

    private void Check_insert(AVLNode node) {/*adjust tree to be balanced*/
        AVLNode temp = node;
        while (temp != null) {/*find the first node to report unbalance and rotate*/
            if (GetHeight(temp.left) - GetHeight(temp.right) == 2) {/*newly inserted node is on the left branch*/
                if (node.key < temp.left.key) {/*node is inserted in temp's left child's left branch*/
                    ll(temp);
                } else {/*node is inserted in temp's left child's right branch*/
                    lr(temp);
                }
                break;
            } else if (GetHeight(temp.left) - GetHeight(temp.right) == -2) {/*newly inserted node is on the right branch*/
                if (node.key < temp.right.key) {/*node is inserted in temp's right child's left branch*/
                    rl(temp);
                } else {/*node is inserted in temp's right child's right branch*/
                    rr(temp);
                }
                break;
            }
            temp = temp.parent;
        }
    }

    //private void Check_delete(AVLNode node) {/*adjust tree to be balanced*/
    //    AVLNode temp = node;
    //    while (temp != null) {/*find the first node to report unbalance and rotate*/
    //        if (GetHeight(temp.left) - GetHeight(temp.right) == 2) {/*deleted node is on the right branch*/
    //            if (temp.right == null || node.key < temp.right.key) {/*node is deleted from temp's right child's left branch*/
    //                rr(temp);
    //            } else {/*node is deleted from temp's right child's right branch*/
    //                rl(temp);
    //            }
    //            break;
    //        } else if (GetHeight(temp.left) - GetHeight(temp.right) == -2) {/*deleted node is on the left branch*/
    //            if (temp.left == null || node.key < temp.left.key) {/*node is deleted from temp's left child's left branch*/
    //                lr(temp);
    //            } else {/*node is deleted from temp's left child's right branch*/
    //                ll(temp);
    //            }
    //            break;
    //        }
    //        temp = temp.parent;
    //    }
    //}

    private void ll(AVLNode node) {
        /**
         * @description left-left rotation caused by ll-insertion or lr-deletion
         * @param node the first node to report unbalance
         * @return void
         * @author zczeng
         * @date 2020/3/11 16:07
         *      p  p        p  p
         *      \ /         \ /
         *      node         m
         *      / \         / \
         *     m   C       A  node
         *    / \             / \
         *   A   B           B  C
         *   (node is the first to report an unbalance)
         */
        System.out.printf("ll rotation for node %d" + "\n", node.key);
        AVLNode p = node.parent;
        AVLNode m = node.left;
        /*m replace the position of node*/
        if (node == this.root) {/*when node is root*/
            this.root = m;
        } else {
            if (p.left == node) {/*node is on the left branch of p*/
                p.left = m;
            } else {
                p.right = m;
            }
        }
        m.parent = p;
        /*assign B to node.left*/
        node.left = m.right;
        if (m.right != null) {/*when B is not null*/
            m.right.parent = node;
        }
        /*assign node to m.right*/
        m.right = node;
        node.parent = m;
        /*update height*/
        UpdateHeight(node); /*update from node up to root*/
    }

    private void rr(AVLNode node) {
        /**
         * @description right-right rotation caused by the rr-insertion or rl-deletion
         * @param node the first to report unbalance
         * @return void
         * @author zczeng
         * @date 2020/3/11 16:05
         *      p   p       p   p
         *      \  /        \  /
         *      node         m
         *     / \          / \
         *   C    m      node  B
         *       / \     / \
         *      A   B   C  A
         */
        System.out.printf("rr rotation for node %d" + "\n", node.key);
        AVLNode p = node.parent;
        AVLNode m = node.right;
        /*m replace the position of node*/
        if (node == this.root) {/*when node is root*/
            this.root = m;
        } else {
            if (p.left == node) {/*node is on the left branch of p*/
                p.left = m;
            } else {
                p.right = m;
            }
        }
        m.parent = p;
        /*assign A to node.right*/
        node.right = m.left;
        if (m.left != null) {/*when A is not null*/
            m.left.parent = node;
        }
        /*assign node to m.left*/
        m.left = node;
        node.parent = m;
        /*update height*/
        UpdateHeight(node);/*update from node up to root*/
    }

    private void lr(AVLNode node) {
        /**
         * @description left-right rotation caused by lr-insertion or ll-deletion
         * @param node the first node to report unbalance
         * @return void
         * @author zczeng
         * @date 2020/3/11 16:08
         *      p   p          p   p
         *      \  /           \  /
         *      node            n
         *      / \            / \
         *     m   D          m   node
         *    / \            / \   / \
         *   A   n          A  B  C  D
         *      / \
         *     B  C
         *   (node is the first to report an unbalance)
         */
        System.out.printf("lr rotation for node %d" + "\n", node.key);
        AVLNode p = node.parent;
        AVLNode m = node.left;
        AVLNode n = m.right;
        /*n replace the position of node*/
        if (node == this.root) {/*when node is root*/
            this.root = n;
        } else {
            if (p.left == node) {/*node is on the left branch of p*/
                p.left = n;
            } else {
                p.right = n;
            }
        }
        n.parent = p;
        /*assign B to m.right*/
        m.right = n.left;
        if (n.left != null) {
            n.left.parent = m;
        }
        /*assign C to node.left*/
        node.left = n.right;
        if (n.right != null) {
            n.right.parent = node;
        }
        /*assign m to n.left*/
        n.left = m;
        m.parent = n;
        /*assign node to n.right*/
        n.right = node;
        node.parent = n;
        /*update height*/
        m.height = max(GetHeight(m.left), GetHeight(m.right)) + 1;
        node.height = max(GetHeight(node.left), GetHeight(node.right)) + 1;
        UpdateHeight(n);
    }

    private void rl(AVLNode node) {
        /**
         * @description right-left rotation caused by rl-insertion for rr-deletion
         * @param node the first node to report unbalance
         * @return void
         * @author zczeng
         * @date 2020/3/11 16:10
         *      p   p         p   p
         *      \  /          \  /
         *      node           n
         *      / \           / \
         *     D   m       node  m
         *        / \      / \  / \
         *       n   A    D  B C  A
         *      / \
         *     B  C
         *     (node is the first to report an unbalance)
         */
        System.out.printf("rl rotation for node %d" + "\n", node.key);
        AVLNode p = node.parent;
        AVLNode m = node.right;
        AVLNode n = m.left;
        /*n replace the position of node*/
        if (node == this.root) {/*when node is root*/
            this.root = n;
        } else {
            if (p.left == node) {/*node is on the left branch of p*/
                p.left = n;
            } else {
                p.right = n;
            }
        }
        n.parent = p;
        /*assign B to node.right*/
        node.right = n.left;
        if (n.left != null) {
            n.left.parent = node;
        }
        /*assign C to m.left*/
        m.left = n.right;
        if (n.right != null) {
            n.right.parent = m;
        }
        /*assign m to n.right*/
        n.right = m;
        m.parent = n;
        /*assign node to n.left*/
        n.left = node;
        node.parent = n;
        /*update height*/
        m.height = max(GetHeight(m.left), GetHeight(m.right)) + 1;
        node.height = max(GetHeight(node.left), GetHeight(node.right)) + 1;
        UpdateHeight(n);
    }

    private void UpdateHeight(AVLNode node) {
        while (node != null) {/*up to root*/
            node.height = max(GetHeight(node.left), GetHeight(node.right)) + 1;
            node = node.parent;
        }
    }

    public static int GetHeight(AVLNode n) {
        if (n == null) {
            return -1;
        }
        return n.height;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int getTreeDepth(AVLNode top) {
        /**
         * @description get the depth of bst
         * @param top root of bst
         * @return int depth
         * @author zczeng
         * @date 2020/2/28 8:59
         */
        return top == null ? 0 : (1 + Math.max(getTreeDepth(top.left), getTreeDepth(top.right)));
    }

    private static void writeArray(AVLNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        /**
         * @description write tree nodes into an array
         * @param currNode current node
         * @param rowIndex row index of node in the array
         * @param columnIndex column index of node in the array
         * @param res array to store nodes
         * @param treeDepth depth of bst
         * @return void
         * @author zczeng
         * @date 2020/2/28 9:14
         */
        if (currNode == null) { /*bst is null*/
            return;
        }
        res[rowIndex][columnIndex] = String.valueOf(currNode.key);/*store current node into a 2-d array*/
        int currLevel = ((rowIndex + 1) / 2);   /*level of current node*/
        if (currLevel == treeDepth) {   /*leave*/
            return;
        }
        int gap = treeDepth - currLevel - 1;
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public void show() {
        /**
         * @description plot tree structure
         * @param top root of bst
         * @return void
         * @author zczeng
         * @date 2020/2/28 9:14
         */
        AVLNode top = this.root;
        if (top == null) System.out.println("EMPTY!");
        int treeDepth = getTreeDepth(top);
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        String[][] res = new String[arrayHeight][arrayWidth];
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }
        writeArray(top, 0, arrayWidth / 2, res, treeDepth);
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
