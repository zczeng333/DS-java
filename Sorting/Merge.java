/**
 * @description merge sort, O(nlogn) complexity
 * @author zczeng
 * @date 2020/2/28 10:02
 */
public class Merge {
    public static int[] merge_sort(int[] args) {
        /**
         * @description merge sort for unordered list
         * @param args unordered list
         * @return int[] ordered list
         * @author zczeng
         * @date 2020/2/27 17:20
         */
        if (args.length == 1) {    /*only 1 element left, return*/
            return new int[]{args[0]};
        }
        int i, j, k;
        int mid = (int) args.length / 2;
        int[] result = new int[args.length];
        int[] left = new int[mid];
        int[] right = new int[args.length - mid];
        for (i = 0; i < mid; i++) {
            left[i] = args[i];
        }
        for (j = 0; j < args.length - mid; j++) {
            right[j] = args[j + mid];
        }
        left = merge_sort(left);    /*left subsequence after sorting*/
        right = merge_sort(right);    /*right subsequence after sorting*/
        i = j = k = 0;
        while (i < args.length) {
            if (j == left.length) {    /*left sequence already sorted*/
                result[i] = right[k];
                k += 1;
            } else if (k == right.length) {    /*right sequence already sorted*/
                result[i] = left[j];
                j += 1;
            } else if (left[j] < right[k]) {    /*compare the smallest element of left & right,and pick the smaller one*/
                result[i] = left[j];
                j += 1;
            } else {
                result[i] = right[k];
                k += 1;
            }
            i = i + 1;
        }
        return result;
    }
}
