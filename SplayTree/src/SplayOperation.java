public class SplayOperation {
    private SplayNode root;

    public SplayOperation(int[] args) {
        /**
         * @description Initialization for SplayTree Operations
         * @param args input int array
         * @return
         * @author zczeng
         * @date 2020/3/15 21:48
         */
        build_splay(args);
    }

    private void build_splay(int[] args) {
        /**
         * @description build up a binary tree based on input array
         * @param args input int array
         * @return void
         * @author zczeng
         * @date 2020/3/15 21:48
         */
        if (args.length > 0) {
            this.root = new SplayNode(args[0]);
            for (int i = 1; i < args.length; i++) {
                insert(args[i]);
            }
        }
    }

    public void insert(int value) {
        /**
         * @description insert node with key=value
         * @param value key of insert node
         * @return void
         * @author zczeng
         * @date 2020/3/15 21:49
         */
        SplayNode node = new SplayNode(value);
        if (this.root == null) {
            this.root = node;
            return;
        } else {
            SplayNode temp = this.root;
            while (true) {
                if (value < temp.key) {/*go left*/
                    if (temp.left != null) {/*not accessible, keep going left*/
                        temp = temp.left;
                        continue;
                    } else {/*successfully insert*/
                        temp.left = node;
                        node.parent = temp;
                        return;
                    }
                } else {/*go right*/
                    if (temp.right != null) {/*not accessible, keep going right*/
                        temp = temp.right;
                        continue;
                    } else {/*successfully insert*/
                        temp.right = node;
                        node.parent = temp;
                        return;
                    }
                }
            }
        }
    }

    public SplayNode Find(int value) {
        /**
         * @description Find node with key=value and rotate the node to the root
         * @param value key of node to be find
         * @return SplayNode
         * @author zczeng
         * @date 2020/3/15 21:49
         */
        SplayNode temp = this.root;
        while (temp != null) {
            if (temp.key == value) {/*find node*/
                rotate(temp);
                return temp;
            }
            if (value < temp.key) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        System.out.println("Unable to find!");
        return null;
    }

    private void rotate(SplayNode node) {
        /**
         * @description rotate node to root
         * @param node node to be rotated
         * @return void
         * @author zczeng
         * @date 2020/3/15 21:50
         */
        System.out.printf("Rotate node with key %d to root \n", node.key);
        while (this.root != node) {
            if (node.parent == this.root) {/*single rotate*/
                if (this.root.left == node) {
                    SingleL(node);
                } else {
                    SingleR(node);
                }
            } else {/*Zigzag or Zigzig*/
                SplayNode P = node.parent;
                SplayNode G = P.parent;
                if (P.right == node && G.left == P) {/*ZigzagLR*/
                    ZigzagLR(node);
                } else if (P.left == node && G.right == P) {/*ZigzagRL*/
                    ZigzagRL(node);
                } else if (P.right == node && G.right == P) {/*ZigzigRR*/
                    ZigzigRR(node);
                } else {
                    ZigzigLL(node);
                }
            }
        }
    }

    private void ZigzagLR(SplayNode X) {
        /**
         * @description when X is the right branch of its grandparent's left child
         * @param X
         * @return void
         * @author zczeng
         * @date 2020/3/15 19:58
         *      G              X
         *     / \           /  \
         *    P   D         P    G
         *   / \      ->   / \  / \
         *  A   X         A  B C  D
         *     / \
         *    B  C
         */
        System.out.println("ZigzagLR");
        SplayNode P = X.parent;
        SplayNode G = P.parent;
        if (G == this.root) {/*when G is the root*/
            this.root = X;
        }
        /*Link X to G.parent*/
        X.parent = G.parent;
        if (G.parent != null) {
            if (G.parent.left == G) {
                G.parent.left = X;
            } else {
                G.parent.right = X;
            }
        }
        /*assign B to P.right*/
        P.right = X.left;
        if (X.left != null) {
            X.left.parent = P;
        }
        /*assign C to G.left*/
        G.left = X.right;
        if (X.right != null) {
            X.right.parent = G;
        }
        /*assign P to X.left and assign G to X.right*/
        X.left = P;
        P.parent = X;
        X.right = G;
        G.parent = X;
    }

    private void ZigzagRL(SplayNode X) {
        /**
         * @description when X is the left branch of its grandparent's right child
         * @param X
         * @return void
         * @author zczeng
         * @date 2020/3/15 20:05
         *      G               X
         *     / \            /  \
         *    A   P          G    P
         *       / \   ->   / \  / \
         *      X  D       A  B C  D
         *     / \
         *    B  C
         */
        System.out.println("ZigzagRL");
        SplayNode P = X.parent;
        SplayNode G = P.parent;
        if (G == this.root) {/*when G is the root*/
            this.root = X;
        }
        /*Link X to G.parent*/
        X.parent = G.parent;
        if (G.parent != null) {
            if (G.parent.left == G) {
                G.parent.left = X;
            } else {
                G.parent.right = X;
            }
        }
        /*assign B to G.right*/
        G.right = X.left;
        if (X.left != null) {
            X.left.parent = G;
        }
        /*assign C to P.left*/
        P.left = X.right;
        if (X.right != null) {
            X.right.parent = P;
        }
        /*assign G to X.left and assign P to X.right*/
        X.left = G;
        G.parent = X;
        X.right = P;
        P.parent = X;
    }

    private void ZigzigLL(SplayNode X) {
        /**
         * @description when X is the left branch of its grandparent's left child
         * @param X
         * @return void
         * @author zczeng
         * @date 2020/3/15 20:08
         *          G            X
         *         / \          / \
         *        P  D         A  P
         *       / \     ->      / \
         *      X  C            B  G
         *     / \                / \
         *    A  B               C  D
         */
        System.out.println("ZigzigLL");
        SplayNode P = X.parent;
        SplayNode G = P.parent;
        if (G == this.root) {/*when G is the root*/
            this.root = X;
        }
        /*Link X to G.parent*/
        X.parent = G.parent;
        if (G.parent != null) {
            if (G.parent.left == G) {
                G.parent.left = X;
            } else {
                G.parent.right = X;
            }
        }
        /*assign B to P.left*/
        P.left = X.right;
        if (X.right != null) {
            X.right.parent = P;
        }
        /*assign C to G.left*/
        G.left = P.right;
        if (P.right != null) {
            P.right.parent = G;
        }
        /*assign G to P.right*/
        P.right = G;
        G.parent = P;
        /*assign P to X.right*/
        X.right = P;
        P.parent = X;
    }

    private void ZigzigRR(SplayNode X) {
        /**
         * @description when X is the right branch of its grandparent's right child
         * @param X
         * @return void
         * @author zczeng
         * @date 2020/3/15 20:14
         *      G                 X
         *     / \               / \
         *    A  P              P  D
         *      / \     ->     / \
         *     B  X           G  C
         *       / \         / \
         *      C  D        A  B
         */
        System.out.println("ZigzigRR");
        SplayNode P = X.parent;
        SplayNode G = P.parent;
        if (G == this.root) {/*when G is the root*/
            this.root = X;
        }
        /*Link X to G.parent*/
        X.parent = G.parent;
        if (G.parent != null) {
            if (G.parent.left == G) {
                G.parent.left = X;
            } else {
                G.parent.right = X;
            }
        }
        /*assign B to G.right*/
        G.right = P.left;
        if (P.left != null) {
            P.left.parent = G;
        }
        /*assign C to P.right*/
        P.right = X.left;
        if (X.left != null) {
            X.left.parent = P;
        }
        /*assign G to P.left*/
        P.left = G;
        G.parent = P;
        /*assign P to X.left*/
        X.left = P;
        P.parent = X;
    }

    private void SingleL(SplayNode X) {
        /**
         * @description when X is the left child of root
         * @param X
         * @return void
         * @author zczeng
         * @date 2020/3/15 20:34
         *      P              X
         *     / \            / \
         *    X  C     ->    A  P
         *   / \               / \
         *  A  B              B  C
         */
        System.out.println("SingleL");
        SplayNode P = X.parent;
        this.root = X;/*update X as the root*/
        /*Link X to G.parent*/
        X.parent = P.parent;
        /*assign B to P.left*/
        P.left = X.right;
        if (X.right != null) {
            X.right.parent = P;
        }
        /*assign P to X.right*/
        X.right = P;
        P.parent = X;
    }

    private void SingleR(SplayNode X) {
        /**
         * @description when X is the right child of root
         * @param X
         * @return void
         * @author zczeng
         * @date 2020/3/15 20:37
         *      P               X
         *     / \             / \
         *    A  X     ->     P  C
         *      / \          / \
         *     B  C         A  B
         */
        System.out.println("SingleR");
        SplayNode P = X.parent;
        this.root = X;/*update X as the root*/
        X.parent = P.parent;
        /*assign B to P.right*/
        P.right = X.left;
        if (X.left != null) {
            X.left.parent = P;
        }
        /*assign P to X.left*/
        X.left = P;
        P.parent = X;
    }

    private int getTreeDepth(SplayNode top) {
        /**
         * @description get the depth of bst
         * @param top root of bst
         * @return int depth
         * @author zczeng
         * @date 2020/2/28 8:59
         */
        return top == null ? 0 : (1 + Math.max(getTreeDepth(top.left), getTreeDepth(top.right)));
    }

    private static void writeArray(SplayNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
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
        SplayNode top = this.root;
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
