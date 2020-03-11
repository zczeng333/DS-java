import java.util.Arrays;

public class AVL {
    public static void main(String[] args) {
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
        //array = new int[]{16, 14, 0, 6, 2, 3, 5, 4, 17, 9};
        System.out.print("Input array:");
        System.out.println(Arrays.toString(array));
        AVLOperation A = new AVLOperation(array);
        A.show();
    }
}
