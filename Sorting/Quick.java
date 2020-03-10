public class Quick {
    public static void quick_sort(int args[], int low, int high) {
        /**
         * @description Qucik sorting for unordered array
         * @param args unordered array
         * @param low low index of the array to be sorted
         * @param high high index of the array to be sorted
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:45
         */
        if (low < high) {/*when array to be processed has more than one element*/
            int i = low;
            int j = high;
            int index = args[low];
            int judge = 0;/*judge=0: modify right side; judge=1: modify left side*/
            while (i != j) {
                if (judge == 0) {/*from right to left (decrease j)*/
                    if (args[j] < index) {
                        args[i] = args[j];
                        judge = 1;
                    } else {
                        j = j - 1;
                    }
                } else {
                    if (args[i] > index) {
                        args[j] = args[i];
                        judge = 0;
                    } else {
                        i = i + 1;
                    }
                }
            }
            args[i] = index;/*i=j currently, and args[i] is the place to fit in index*/
            quick_sort(args, low, i - 1);/*continue sorting left side*/
            quick_sort(args, i + 1, high);/*continue sorting right side*/
        }
    }
}
