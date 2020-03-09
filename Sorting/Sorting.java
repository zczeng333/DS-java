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

        /*Insertion Sort*/
        array = random_array(l, range);
        System.out.println("Insertion Sorting:");
        System.out.printf(Arrays.toString(array) + " -> ");
        result = Insert.insert_sort(array);
        System.out.println(Arrays.toString(result) + "\n");

        /*Merge Sort*/
        array = random_array(l, range);
        System.out.println("Merge Sorting:");
        System.out.printf(Arrays.toString(array) + " -> ");
        result = Merge.merge_sort(array);
        System.out.println(Arrays.toString(result) + "\n");

        /*Heap Sort*/
        array = random_array(l, range);
        System.out.println("Heap Sorting:");
        System.out.printf(Arrays.toString(array) + " -> ");
        result = Heap.heap_sort(array);
        System.out.println(Arrays.toString(result) + "\n");

        /*Binary Search Tree Sort*/
        array = random_array(l, range);
        System.out.println("BST Sorting:");
        System.out.printf(Arrays.toString(array) + " -> ");
        result = BST.bst_sort(array);
        System.out.println(Arrays.toString(result) + "\n");

        /*Shell Sort*/
        array = random_array(l, range);
        System.out.println("Shell Sorting:");
        System.out.printf(Arrays.toString(array) + " -> ");
        result = Shell.shell_sort(array);
        System.out.println(Arrays.toString(result) + "\n");

        /*Quick Sort*/
        array = random_array(l, range);
        System.out.println("Quick Sorting:");
        System.out.printf(Arrays.toString(array) + " -> ");
        Quick.quick_sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array) + "\n");

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

    public static int[] random_array(int l, int range) {
        int[] array = new int[l];
        for (int i = 0; i < l; i++) {
            array[i] = (int) (Math.random() * range);
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    i = i - 1;
                    break;
                }
            }
        }
        return array;
    }
}