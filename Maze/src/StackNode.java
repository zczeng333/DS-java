public class StackNode {
    public StackNode(StackNode next, int[] value) {
        /**
         * @description Node data structure for stack
         * @param next pointer point to next element in stack
         * @param value value stored in node
         * @return
         * @author zczeng
         * @date 2020/3/2 8:24
         */
        this.next = next;
        this.value = value;
    }

    public StackNode next;
    public int[] value;
}
