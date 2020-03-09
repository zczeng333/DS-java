public class Shell {
    public static int[] shell_sort(int[] args) {
        int len = args.length;
        int gap = len / 2;
        int i, j, k, max_k, temp;
        while (gap >= 1) {
            for (i = 0; i < gap; i++) {/*for different groups*/
                if (gap * (len / gap) + i < len) {/*find the biggest element for group i*/
                    max_k = gap * (len / gap) + i;
                } else {
                    max_k = gap * (int) (len / gap) + i - gap;
                }
                for (j = i; j < len - gap; j = j + gap) {/*for each element in one group*/
                    k=max_k;
                    while (k > j) {/*apply insert sort for each element*/
                        if (args[k - gap] > args[k]) {
                            temp = args[k];
                            args[k] = args[k - gap];
                            args[k - gap] = temp;
                        }
                        k = k - gap;
                    }
                }
            }
            gap = gap / 2;
        }
        return args;
    }
}
