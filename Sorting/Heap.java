/**
 * @description heap sort, O(nlogn) complexity
 * @author zczeng
 * @date 2020/2/28 9:50
 */
public class Heap {
    public static int[] max_heap(int[] args, int ind, int size) {
        /**
         * @description correct heap structure when violation happens
         * @param args original heap with violation
         * @param ind index of violation node
         * @param size size of heap
         * @return int[] rectified heap
         * @author zczeng
         * @date 2020/2/27 17:14
         */
        if (ind > (int) (size - 1) / 2) {    /*leaves do not need maxify*/
            return args;
        }
        int left = ind * 2 + 1;
        int right = ind * 2 + 2;
        int max = ind;
        if (left < size && args[max] < args[left]) {
            max = left;
        }
        if (right < size && args[max] < args[right]) {
            max = right;
        }
        if (ind == max) {    /*already a heap*/
            return args;
        }
        int temp = args[max];
        args[max] = args[ind];
        args[ind] = temp;
        args = max_heap(args, max, size);
        return args;
    }

    public static int[] build_heap(int[] args) {
        /**
         * @description build up a heap for input list
         * @param args unordered list
         * @return int[] ordered heap
         * @author zczeng
         * @date 2020/2/27 17:14
         */
        int size = args.length;
        int[] result = args;
        int i;
        for (i = (int) (size - 1) / 2; i >= 0; i--) {
            result = max_heap(result, i, size);
        }
        return result;
    }

    public static int[] heap_sort(int[] args) {
        /**
         * @description heap sort for unordered list
         * @param args unordered list
         * @return int[] ordered list
         * @author zczeng
         * @date 2020/2/27 17:14
         */
        int[] heap = build_heap(args);
        int size = args.length;
        int[] result = new int[size];
        for (int i = args.length - 1; i >= 0; i--) {
            result[i] = heap[0];
            heap[0] = heap[size - 1];
            heap[size - 1] = result[i];    /*exclude max value from heap*/
            size = size - 1;
            heap = max_heap(heap, 0, size);
        }
        return result;
    }
}
