import java.util.Arrays;

public class Queue {
    public static void main(String[] args) {
        /**
         * test for QueueOperation
         */
        System.out.println("Test for QueueOperation");
        int l = 10;    /*length of array*/
        int range = 20;    /*range of elements*/
        float[] array = new float[l];    /*store original array*/
        for (int i = 0; i < l; i++) {
            array[i] = (float) (Math.random() * range);
        }
        System.out.println("Input Array: ");
        System.out.println(Arrays.toString(array));
        QueueOperation Q = new QueueOperation(array, 11);
        Q.enqueue(1);
        Q.enqueue(2);
        Q.dequeue();
        Q.dispose();
        System.out.println(Q.IsEmpty());
        Q.dequeue();
    }
}
