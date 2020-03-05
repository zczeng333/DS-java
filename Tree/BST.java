/**
 * @description binary search tree sorting, O(nlogn) complexity
 * @author zczeng
 * @date 2020/2/28 9:49
 */

import java.util.Enumeration;
import java.util.Vector;

public class BST {
    public static BstNode build_bst(int[] args) {
        /**
         * @description build up binary search tree for an unordered list
         * @param args unordered list
         * @return BstNode root node of the binary search tree
         * @author zczeng
         * @date 2020/2/27 21:30
         */
        int size = args.length;
        BstNode top = new BstNode(null, null, null, args[0]);
        BstNode temp = top;
        for (int i = 1; i < size; i++) {
            BstNode node = new BstNode(null, null, null, args[i]);
            while (true) {  /*find the proper place to add the node*/
                if (temp.value > node.value) {  /*add node to left branch if applicable*/
                    if (temp.left == null) {    /*check whether left branch is empty*/
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.left;   /*otherwise, keep going left*/
                    }
                } else {    /*add node to left branch if applicable*/
                    if (temp.right == null) {   /*check whether right branch is empty*/
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.right;  /*otherwise, keep going right*/
                    }
                }
            }
            temp = top;
        }
        return top;
    }

    public static BstNode delete(BstNode top, BstNode node) {
        /**
         * @description delete node from bst
         * @param top root of bst
         * @param node node to be deleted
         * @return BstNode new root of bst
         * @author zczeng
         * @date 2020/2/27 23:37
         */
        if (node == null) { /*node is null*/
            return top;
        } else {
            if (node.left == null && node.right == null) {/*the node is a leave*/
                if (node.parent == null) {  /*root*/
                    return null;
                } else if (node.parent.left == node) {  /*node is on the left branch*/
                    node.parent.left = null;
                } else {    /*node is on the right branch*/
                    node.parent.right = null;
                }
                return top;
            } else if (node.left == null && node.right != null) {   /*the node only has right branch*/
                if (node.parent == null) {  /*root*/
                    top = node.right;   /*top becomes the right child*/
                    node.right.parent = null;   /*set right child as root*/
                } else if (node.parent.left == node) {  /*node is on the left branch*/
                    node.parent.left = node.right;
                    node.right.parent = node.parent;
                } else {    /*node is on the right branch*/
                    node.parent.right = node.right;
                    node.right.parent = node.parent;
                }
                node.left = null;
                node.right = null;
                node.parent = null;
            } else if (node.left != null && node.right == null) {   /*the node only has left branch*/
                if (node.parent == null) {/*root*/
                    top = node.left;
                    node.left.parent = null;
                } else if (node.parent.left == node) {  /*node is on the left branch*/
                    node.parent.left = node.left;
                    node.left.parent = node.parent;
                } else {/*node is on the right branch*/
                    node.parent.right = node.left;
                    node.left.parent = node.parent;
                }
            } else if (node.left != null && node.right != null) {   /*have both left and right branches*/
                BstNode pointer = node.right;  /*find the biggest value in the right branch*/
                while (pointer.left != null) {  /*find the most left child of node.right*/
                    pointer = pointer.left;
                }
                if (pointer.right != null) {
                    pointer.right.parent = pointer.parent;
                }
                /*
                 * This is super tricky, cause you can't guarantee that pointer is on the left branch of its parent
                 * (when pointer=node.right, pointer.left=pointer.right=null)
                 * */
                if (pointer.parent.left == pointer) {
                    pointer.parent.left = pointer.right;
                } else {
                    pointer.parent.right = pointer.right;
                }
                node.value = pointer.value;
            }
        }
        return top;
    }

    public static void insert(BstNode top, int value) {
        /**
         * @description insert new value into Bst
         * @param top root of bst
         * @param value new value to be inserted
         * @return void
         * @author zczeng
         * @date 2020/3/5 23:10
         */
        BstNode node = new BstNode(null, null, null, value);
        BstNode temp = top;
        while (true) {  /*find the proper place to add the node*/
            if (temp.value > node.value) {  /*add node to left branch if applicable*/
                if (temp.left == null) {    /*check whether left branch is empty*/
                    temp.left = node;
                    node.parent = temp;
                    break;
                } else {
                    temp = temp.left;   /*otherwise, keep going left*/
                }
            } else {    /*add node to left branch if applicable*/
                if (temp.right == null) {   /*check whether right branch is empty*/
                    temp.right = node;
                    node.parent = temp;
                    break;
                } else {
                    temp = temp.right;  /*otherwise, keep going right*/
                }
            }
        }
    }

    public static BstNode bfs(BstNode top, int value) {
        /**
         * @description breadth first search
         * @param top root of bst
         * @param value value to be found
         * @return BstNode node with corresponding value
         * @author zczeng
         * @date 2020/2/27 23:39
         */
        Vector frontier = new Vector();
        Vector next = new Vector();
        if (top.value == value) {
            return top;
        }
        frontier.add(top);
        while (!frontier.isEmpty()) {
            Enumeration enu1 = frontier.elements();
            while (enu1.hasMoreElements()) {
                BstNode temp = (BstNode) enu1.nextElement();
                if (temp.left != null) {
                    if (temp.left.value == value) {
                        return temp.left;
                    }
                    next.add(temp.left);
                }
                if (temp.right != null) {
                    if (temp.right.value == value) {
                        return temp.right;
                    }
                    next.add(temp.right);
                }
            }
            frontier.clear();
            Enumeration enu2 = next.elements();
            while (enu2.hasMoreElements()) {    /*exchange frontier and next*/
                frontier.add(enu2.nextElement());
            }
            next.clear();
        }
        return null;
    }

    public static int[] bst_sort(int[] args) {
        /**
         * @description bst sorting algorithm
         * @param args unordered array
         * @return int[] ordered array
         * @author zczeng
         * @date 2020/2/28 9:45
         */
        BstNode top = build_bst(args); /*build up bst*/
        BstNode temp;
        int[] result = new int[args.length];
        int i = 0;
        while (top != null) {
            temp = top;
            while (temp.left != null) {  /*find smallest value in current bst*/
                temp = temp.left;
            }
            result[i] = temp.value; /*record value*/
            i = i + 1;
            top = delete(top, temp);    /*delete node from bst*/
        }
        return result;
    }

    public static BstNode findmin(BstNode top) {
        /**
         * @description find node with the minimum value of Bst
         * @param top root of bst
         * @return BstNode node with minimum value
         * @author zczeng
         * @date 2020/3/5 23:11
         */
        BstNode pointer = top;
        while (pointer.left != null) {
            pointer = pointer.left;
        }
        return pointer;
    }

    public static BstNode findmax(BstNode top) {
        /**
         * @description find node with the maximum value of bst
         * @param top root of bst
         * @return BstNode node with maximum value
         * @author zczeng
         * @date 2020/3/5 23:12
         */
        BstNode pointer = top;
        while (pointer.right != null) {
            pointer = pointer.right;
        }
        return pointer;
    }


    /**
     * Plot the structure of bst
     */
    public static void print_bst(BstNode top) {
        /**
         * @description print binary search tree
         * @param top root node of the binary search tree
         * @return void
         * @author zczeng
         * @date 2020/2/27 21:30
         */
        Vector frontier = new Vector();
        Vector record = new Vector();
        Vector next = new Vector();
        frontier.add(top);
        record.add(top.value);
        while (!frontier.isEmpty()) {
            Enumeration enu1 = frontier.elements();
            while (enu1.hasMoreElements()) {
                BstNode temp = (BstNode) enu1.nextElement();
                if (temp.left != null) {
                    record.add(temp.left.value);
                    next.add(temp.left);
                }
                if (temp.right != null) {
                    record.add(temp.right.value);
                    next.add(temp.right);
                }
            }
            frontier.clear();
            Enumeration enu2 = next.elements();
            while (enu2.hasMoreElements()) {    /*exchange frontier and next*/
                frontier.add(enu2.nextElement());
            }
            next.clear();
        }
        Enumeration enu = record.elements();
        System.out.println("Binary Search Tree:");
        while (enu.hasMoreElements())
            System.out.print(enu.nextElement() + ", ");
    }

    public static int getTreeDepth(BstNode top) {
        /**
         * @description get the depth of bst
         * @param top root of bst
         * @return int depth
         * @author zczeng
         * @date 2020/2/28 8:59
         */
        return top == null ? 0 : (1 + Math.max(getTreeDepth(top.left), getTreeDepth(top.right)));
    }

    private static void writeArray(BstNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
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
        res[rowIndex][columnIndex] = String.valueOf(currNode.value);/*store current node into a 2-d array*/
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

    public static void show(BstNode top) {
        /**
         * @description plot tree structure
         * @param top root of bst
         * @return void
         * @author zczeng
         * @date 2020/2/28 9:14
         */
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
