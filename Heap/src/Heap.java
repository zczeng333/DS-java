import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        System.out.println("Test for Heap");
        int MaxElement = 15;  /*max size of heap*/
        int[] heap = new int[MaxElement + 1];
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
        System.out.print("Input array:");
        System.out.println(Arrays.toString(array));

        HeapOperation h = new HeapOperation(MaxElement);
        h.BuildHeap(array);
        heap = h.GetHeap();
        System.out.print("Binary Heap: ");
        System.out.println(Arrays.toString(heap));

        int insert_value = (int) (Math.random() * range);
        for (i = 0; i < heap.length; i++) {
            if (insert_value == heap[i]) {
                i = 0;
                insert_value = (int) (Math.random() * range);
            }
        }
        System.out.printf("Insert %d: ", insert_value);
        h.Insert(insert_value);
        heap = h.GetHeap();
        System.out.println(Arrays.toString(heap));

        System.out.print("Delete min value in heap: ");
        h.Delete_min();
        heap = h.GetHeap();
        System.out.println(Arrays.toString(heap));

        System.out.printf("Decrease %d to %d: ", heap[5], heap[5] - 3);
        h.DecreaseKey(5, -3);
        heap = h.GetHeap();
        System.out.print(Arrays.toString(heap));

        System.out.printf("\n" + "Increase %d to %d: ", heap[3], heap[3] + 5);
        h.IncreaseKey(3, 5);
        heap = h.GetHeap();
        System.out.print(Arrays.toString(heap));

        System.out.printf("\n"+"Delete %d: ",heap[2]);
        h.Delete(2);
        heap=h.GetHeap();
        System.out.print(Arrays.toString(heap));

        System.out.printf("\n" + "Minimum value: %d", h.FindMin());
    }
}