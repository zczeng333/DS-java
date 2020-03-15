import java.util.Arrays;

public class SplayTree {
    public static void main(String[] args) {
        int l = 10;    /*length of array*/
        int range = 20;    /*range of elements*/
        int[] array = new int[l];    /*store original array*/
        //int i, j;
        //for (i = 0; i < l; i++) {
        //    int temp = (int) (Math.random() * range);
        //    for (j = 0; j < i; j++) {
        //        if (temp == array[j]) {
        //            i = i - 1;
        //            break;
        //        }
        //    }
        //    if (j == i) {
        //        array[i] = temp;
        //    }
        //}
        /*test for ZigzagRL, ZigzigRR and SingleR*/
        System.out.printf("\ntest for ZigzagRL, ZigzigRR and SingleR\n");
        array = new int[]{1, 2, 3, 4, 6, 5};
        System.out.print("Input array:");
        System.out.println(Arrays.toString(array));
        SplayOperation A = new SplayOperation(array);
        A.Find(5);
        A.show();
        /*test for ZigzagLR, ZigzigLL and SingleL*/
        System.out.printf("\ntest for ZigzagLR, ZigzigLL and SingleL\n");
        array = new int[]{6, 5, 4, 3, 1, 2};
        System.out.print("Input array:");
        System.out.println(Arrays.toString(array));
        SplayOperation B = new SplayOperation(array);
        B.Find(2);
        B.show();
        /*test for deletion*/
        System.out.printf("\nTest for deletion\n");
        B.delete(4);
        B.show();
    }
}
