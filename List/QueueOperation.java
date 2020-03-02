public class QueueOperation {
    public QueueOperation(float[] array, int max_size) {
        /**
         * @description Set up queue data structure based on input array and max size
         * @param array input float array
         * @param max_size max size of queue
         * @return
         * @author zczeng
         * @date 2020/3/2 8:37
         */
        this.max_size = max_size;
        this.size = 0;
        if (array.length > 0) {
            QueueNode temp = new QueueNode(null, array[0]);
            this.size = 1;
            front.next = temp;
            rear.next = temp;
            for (int i = 1; i < array.length; i++) {
                if (this.size >= max_size) {
                    System.out.println("Queue is full");
                    break;
                }
                this.size = this.size + 1;
                QueueNode node = new QueueNode(null, array[i]);
                temp.next = node;
                temp = node;
                rear.next = node;
            }
        } else {
            System.out.println("No input data, Empty queue!");
        }
    }

    public boolean IsEmpty() {
        /**
         * @description judge whether the queue is empty
         * @param
         * @return boolean
         * @author zczeng
         * @date 2020/3/2 8:38
         */
        if (this.front.next == null) {
            return true;
        }
        return false;
    }

    public void dispose() {
        /**
         * @description dispose the queue: print all element FIFO, and destroy the queue
         * @param
         * @return void
         * @author zczeng
         * @date 2020/3/2 8:38
         */
        while (this.front.next != null) {
            System.out.println(this.front.next.value);
            this.front.next = this.front.next.next;
            this.size = this.size - 1;
        }
    }

    public void enqueue(float value) {
        /**
         * @description enqueue a new node with value
         * @param value value of the new node
         * @return void
         * @author zczeng
         * @date 2020/3/2 8:39
         */
        if (this.size >= this.max_size) {
            System.out.printf("Queue is full, unable to enqueue element %f" + "\n", value);
        } else {
            System.out.printf("Enqueue element %f" + "\n", value);
            QueueNode node = new QueueNode(null, value);
            this.rear.next.next = node;
            this.rear.next = node;
            this.size = this.size + 1;
        }
    }

    public float dequeue() {
        /**
         * @description dequeue the front node of the queue
         * @param
         * @return float value of the node dequeued
         * @author zczeng
         * @date 2020/3/2 8:40
         */
        if (this.size == 0) {
            System.out.println("Queue is empty, unable to dequeue");
            return -1;
        } else {
            float value = this.front.next.value;
            this.front.next = this.front.next.next;
            this.size = this.size - 1;
            System.out.printf("Dequeue element %f" + "\n", value);
            return value;
        }
    }

    public float front() {
        /**
         * @description get the value of front node
         * @param
         * @return float value of the front node
         * @author zczeng
         * @date 2020/3/2 8:39
         */
        if (this.front.next == null) {
            System.out.println("Queue is empty, nothing at the front");
            return -1;

        } else {
            return this.front.next.value;
        }
    }

    private QueueNode front = new QueueNode(null, 0);/*front pointer of the queue*/
    private QueueNode rear = new QueueNode(null, 0);/*rear pointer of the queue*/
    private int max_size;/*max size of the queue*/
    private int size;/*size of the current queue*/
}