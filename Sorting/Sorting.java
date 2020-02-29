/**
 * Sorting algorithms (ascending order)
 */

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int l = 10;    /*length of array*/
        int range = 20;    /*range of elements*/
        int[] array = new int[l];    /*store original array*/
        int[] result;
        for (int i = 0; i < l; i++) {
            array[i] = (int) (Math.random() * range);
        }
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array) + "\n");
        result = Insert.insert_sort(array);
        System.out.println("Insertion Sorting:");
        System.out.println(Arrays.toString(result) + "\n");
        result = Merge.merge_sort(array);
        System.out.println("Merge Sorting:");
        System.out.println(Arrays.toString(result) + "\n");
        result = Heap.heap_sort(array);
        System.out.println("Heap Sorting:");
        System.out.println(Arrays.toString(result) + "\n");
        result = BST.bst_sort(array);
        System.out.println("BST Sorting:");
        System.out.println(Arrays.toString(result) + "\n");

        ///**
        // * test bst
        // */
        //array = new int[]{8, 4, 2, 3, 7, 5, 6, 12, 9, 11, 10};
        //array = new int[]{8, 4, 2, 3, 6, 5, 12, 9, 11, 10};
        //System.out.println("BST Sorting:");
        //TreeNode top = BST.build_bst(array);
        //System.out.println("Original bst:");
        //BST.show(top);
        //TreeNode node = BST.bfs(top, 8);
        //top = BST.delete(top, node);
        //System.out.println("Processed bst:");
        //BST.show(top);
    }
}