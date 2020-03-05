import java.util.Arrays;

public class Tree {
    public static void main(String[] args) {
        /**
         * test for TreeOperation
         */
        System.out.println("Test for TreeOperation");
        int l = 10;    /*length of array*/
        int range = 20;    /*range of elements*/
        int[] array = new int[l];    /*store original array*/
        int i, j;
        for (i = 0; i < l; i++) {
            int temp = (int) (Math.random() * range);
            for (j = 0; j < i; j++) {
                if (temp == array[j]) {
                    i = i - 1;
                    break;
                }
            }
            if (j == i) {
                array[i] = temp;
            }
        }
        //int[] array = new int[]{2, 17, 1, 18, 15, 12, 11, 4, 6, 13};
        System.out.println("Input Array: ");
        System.out.println(Arrays.toString(array));
        TreeOperation T = new TreeOperation(array);
        TreeNode root = T.get_root();
        System.out.println("Pre-order tree traversal");
        T.pre_order(root);
        System.out.println("\n" + "Post-order tree traversal");
        T.post_order(root);
        System.out.println("\n" + "In-order tree traversal");
        T.in_order(root);
        System.out.println("\n" + "Binary Search Tree");
        BstNode top = BST.build_bst(array);
        BST.show(top);
        System.out.printf("\n" + "Delete " + "%d" + " in tree" + "\n", array[2]);
        BstNode node = BST.bfs(top, array[2]); /*apply breadth first search*/
        BstNode result = BST.delete(top, node);/*delete node from bst*/
        BST.show(result);
        System.out.println("\n" + "Insert element 5 into bst");
        BST.insert(top, 5);
        BST.show(top);
        System.out.printf("\n" + "max element: %d" + "\n", BST.findmax(top).value);
        System.out.printf("\n" + "min element: %d" + "\n", BST.findmin(top).value);
    }
}