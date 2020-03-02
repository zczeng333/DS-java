import java.util.Arrays;

public class Stack {
    public static void main(String[] args) {
        /**
         * test for StackOperation
         */
        System.out.println("Test for StackOperation");
        int l = 10;    /*length of array*/
        int range = 20;    /*range of elements*/
        float[] array = new float[l];    /*store original array*/
        for (int i = 0; i < l; i++) {
            array[i] = (float) (Math.random() * range);
        }
        System.out.println("Input Array: ");
        System.out.println(Arrays.toString(array));
        StackOperation S = new StackOperation(array, 11);
        S.push(1);
        S.push(2);
        S.pop();
        S.dispose();
        System.out.println(S.IsEmpty());
        S.pop();
    }
}
