/**
 * @description insertion sorting, O(n^2) complexity
 * @author zczeng
 * @date 2020/2/28 9:51
 */
public class Insert {
    public static int[] insert_sort(int[] args) {
        /**
         * @description insertion sorting for unordered list
         * @param args unordered list
         * @return int[] ordered list
         * @author zczeng
         * @date 2020/2/27 17:19
         */
        int i, j, temp;
        for (i = 0; i < args.length - 1; i++) {
            for (j = args.length - 1; j > i; j--) {
                if (args[j] < args[j - 1]) {    /*compare adjacent elements*/
                    temp = args[j];
                    args[j] = args[j - 1];
                    args[j - 1] = temp;
                }
            }
        }
        return args;
    }
}
