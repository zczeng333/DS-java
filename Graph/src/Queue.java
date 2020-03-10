public class Queue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public Queue() {
        this.front = new QueueNode(-1);
        this.rear = new QueueNode(-1);
        this.size = 0;
    }

    public void enqueue(QueueNode n) {
        /**
         * @description enqueue node n into the queue
         * @param n queue node
         * @return void
         * @author zczeng
         * @date 2020/3/10 16:34
         */
        if (this.size == 0) {
            this.front.next = n;
        } else {
            this.rear.next.next = n;
        }
        this.rear.next = n;
        this.size = this.size + 1;
    }

    public QueueNode dequeue() {
        /**
         * @description dequeue element from the queue
         * @param
         * @return QueueNode
         * @author zczeng
         * @date 2020/3/10 16:34
         */
        if (this.size == 0) {
            System.out.println("Empty Queue, unable to dequeue");
            return null;
        } else {
            QueueNode temp = this.front.next;
            this.front.next = this.front.next.next;
            this.size = this.size - 1;
            if (this.size == 0) {/*empty queue*/
                this.rear.next = null;
            }
            return temp;
        }
    }

    public boolean IsEmpty() {
        return this.size == 0;
    }
}
