import java.util.Arrays;

public class List {
    public static void main(String[] args) {
        /**
         * test for ListOperation
         * */
        System.out.println("Test for ListOperation");
        int l = 10;    /*length of array*/
        int range = 20;    /*range of elements*/
        float[] array = new float[l];    /*store original array*/
        for (int i = 0; i < l; i++) {
            array[i] = (float) (Math.random() * range);
        }
        ListOperation op = new ListOperation(null, array);
        System.out.printf("Length of list: " + "%d" + "\n", op.length());
        op.print_list();/*Test print function*/
        System.out.printf("Find 5th element value: " + "%.2f" + "\n", op.find(5).value);/*Test find function*/
        ListNode add = new ListNode(null, null, (float) 13.57);
        System.out.printf("Insert (7th): ");
        op.insert(add, 7);/*Test insert function*/
        op.print_list();
        System.out.printf("Delete (10th): ");
        op.delete(10);/*Test delete function*/
        op.print_list();
        System.out.println();


        /**
         * test for Polynomial
         * */
        System.out.println("Test for Polynomial");
        int l1 = 3;    /*length of polynomial1*/
        int l2 = 6;    /*length of polynomial2*/
        int r = 10;
        float[] coef1 = new float[l1];    /*store original array*/
        float[] coef2 = new float[l2];
        int[] d1 = new int[l1];
        int[] d2 = new int[l2];
        int i;
        for (i = 0; i < l1; i++) {
            coef1[i] = (float) (Math.random() * r);
            d1[i] = (int) (Math.random() * r);
        }
        for (i = 0; i < l2; i++) {
            coef2[i] = (float) (Math.random() * r);
            d2[i] = (int) (Math.random() * r);
        }
        Polynomial A = new Polynomial(coef1, d1);
        Polynomial B = new Polynomial(coef2, d2);
        Polynomial result = Polynomial.multiple(A, B);/*Test multiple function*/
        System.out.print("Polynomial 1: ");
        A.print_polynomial();/*Test print function*/
        System.out.print("Polynomial 2: ");
        B.print_polynomial();
        System.out.print("Multiplication result: ");
        result.print_polynomial();
    }
}