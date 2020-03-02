public class StackOperation {
    private StackNode sp = new StackNode(null, 0);/*stack pointer*/
    private int size;/*size of current stack*/
    private int max_size;/*max size of stack*/

    public StackOperation(float[] array, int max_size) {
        /**
         * @description Set up Stack data structure based on input array and max size
         * @param array input array (array.size==0 when no input array)
         * @param max_size max size of stack
         * @return
         * @author zczeng
         * @date 2020/3/2 8:26
         */
        this.max_size = max_size;
        this.size = 0;
        if (array.length > 0) {
            StackNode temp = new StackNode(null, array[0]);
            this.sp.next = temp;
            this.size = this.size + 1;
            for (int i = 1; i < array.length; i++) {
                if (this.size >= this.max_size) {
                    System.out.println("Stack is full!");
                    break;
                }
                this.size = this.size + 1;
                StackNode node = new StackNode(temp, array[i]);
                this.sp.next = node;
                temp = node;
            }
        } else {
            System.out.println("No input data, Empty stack!");
        }
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

    public void push(float value) {
        /**
         * @description push a new element into the stack
         * @param value value of the new node
         * @return void
         * @author zczeng
         * @date 2020/3/2 8:28
         */
        if (this.size == this.max_size) {
            System.out.printf("Stack is full, unable to push element %f" + "\n", value);
        } else {
            System.out.printf("Push element %f" + "\n", value);
            this.size = this.size + 1;
            StackNode node = new StackNode(this.sp.next, value);
            this.sp.next = node;
        }
    }

    public float pop() {
        /**
         * @description pop stack
         * @param
         * @return float value of the node popped out
         * @author zczeng
         * @date 2020/3/2 8:28
         */
        if (this.sp.next == null) {
            System.out.println("Stack is empty, unable to pop");
            return -1;
        } else {
            float value = this.sp.next.value;
            this.sp.next = this.sp.next.next;
            this.size = this.size - 1;
            System.out.printf("Pop element %f" + "\n", value);
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
        while (this.sp.next != null) {
            System.out.println(this.sp.next.value);
            this.sp.next = this.sp.next.next;
            this.size = this.size - 1;
        }
    }

    public float top() {
        if (this.sp.next == null) {
            System.out.println("Stack is empty, nothing at the top");
            return -1;
        }
        return this.sp.next.value;
    }

    public int get_size() {
        return this.size;
    }
}
