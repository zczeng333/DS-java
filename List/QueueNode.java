public class QueueNode {
    public QueueNode(QueueNode next, float value) {
        /**
         * @description Node data structure for Queue
         * @param next next node
         * @param value key value of current node
         * @return
         * @author zczeng
         * @date 2020/3/5 23:08
         */
        this.next = next;
        this.value = value;
    }

    public QueueNode next;
    public float value;
}
