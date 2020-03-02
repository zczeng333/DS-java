public class QueueNode {
    public QueueNode(QueueNode next, float value) {
        this.next = next;
        this.value = value;
    }

    public QueueNode next;
    public float value;
}
