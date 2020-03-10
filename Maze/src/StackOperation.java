import java.util.Arrays;

public class StackOperation {
    private StackNode sp;/*stack pointer*/
    private int size;/*size of current stack*/

    public StackOperation() {
        /**
         * @description Set up Stack data structure based on input array and max size
         * @param array input array (array.size==0 when no input array)
         * @param max_size max size of stack
         * @return
         * @author zczeng
         * @date 2020/3/2 8:26
         */
        this.size = 0;
        this.sp = new StackNode(null, new int[]{-1, -1});
    }

    public boolean IsEmpty() {
        /**
         * @description judge whether the stack is empty
         * @param
         * @return boolean
         * @author zczeng
         * @date 2020/3/2 8:27
         */
        if (this.sp.next == null) {
            return true;
        }
        return false;
    }

    public void push(int[] value) {
        /**
         * @description push a new element into the stack
         * @param value value of the new node
         * @return void
         * @author zczeng
         * @date 2020/3/2 8:28
         */
        this.size = this.size + 1;
        StackNode node = new StackNode(this.sp.next, value);
        this.sp.next = node;
    }

    public int[] pop() {
        /**
         * @description pop stack
         * @param
         * @return float value of the node popped out
         * @author zczeng
         * @date 2020/3/2 8:28
         */
        if (this.sp.next == null) {
            System.out.println("Stack is empty, unable to pop");
            return null;
        } else {
            int[] value = this.sp.next.value;
            this.sp.next = this.sp.next.next;
            this.size = this.size - 1;
            return value;
        }
    }

    public void dispose() {
        /**
         * @description dispose the stack: print all element FILO, and destroy stack
         * @param
         * @return void
         * @author zczeng
         * @date 2020/3/2 8:29
         */
        int count = 0;
        while (this.sp.next.next != null) {
            System.out.printf(Arrays.toString(this.sp.next.value) + " -> ");
            count = count + 1;
            if (count % 10 == 0) {
                System.out.println();
                count = 0;
            }
            this.sp.next = this.sp.next.next;
            this.size = this.size - 1;
        }
        System.out.printf(Arrays.toString(this.sp.next.value));
    }

    public int[] top() {
        if (this.sp.next == null) {
            System.out.println("Stack is empty, nothing at the top");
            return null;
        }
        return this.sp.next.value;
    }

    public int get_size() {
        return this.size;
    }
}
