/**
 * @description binary search, O(nlogn) complexity
 * @author zczeng
 * @date 2020/2/28 9:48
 */
public class BS {
    public static int binary1(int[] args, int x) {
        /**
         * @description binary search algorithm 1
         * @param args  ordered array
         * @param x key value to be found
         * @return int index of x
         * @author zczeng
         * @date 2020/2/28 9:46
         */
        int mid = (int) (args.length - 1) / 2;
        int i;
        int ind = -1;
        if (args[mid] == x) {
            return mid;    /*find index*/
        }
        if (mid == 0 || mid == args.length - 1) {    /*can't find*/
            return -1;
        }
        if (args[mid] > x) {    /*left subsequence*/
            int[] temp = new int[mid];
            for (i = 0; i < mid; i++) {
                temp[i] = args[i];
            }
            ind = binary1(temp, x);
        } else {    /*right subsequence*/
            int[] temp = new int[args.length - mid - 1];
            for (i = mid + 1; i < args.length; i++) {
                temp[i - mid - 1] = args[i];
            }
            ind = binary1(temp, x);
            if (ind != -1) {
                ind = mid + 1 + ind;
            }
        }
        return ind;
    }

    public static int binary2(int[] args, int x) {
        /**
         * @description binary search algorithm 2
         * @param args ordered array
         * @param x key value to be found
         * @return int index of x
         * @author zczeng
         * @date 2020/2/28 9:47
         */
        int mid = (int) (args.length - 1) / 2;
        int low = 0;
        int high = args.length - 1;
        while (args[mid] != x) {
            if (high == low) {
                mid = -1;
                break;
            }
            if (args[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (int) (low + high) / 2;
        }
        return mid;
    }

    //public static void main(String[] args) {//test
    //    int[] array = new int[]{1, 2, 5, 7, 9, 13, 17, 25, 53, 68};
    //    int x = 100;
    //    System.out.print("binary search 1:");
    //    int ind = binary1(array, x);
    //    System.out.println(ind);
    //    System.out.print("binary search 2:");
    //    ind = binary2(array, x);
    //    System.out.println(ind);
    //}
}