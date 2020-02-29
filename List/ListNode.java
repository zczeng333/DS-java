public class ListNode {
    public ListNode(ListNode parent, ListNode child, float value) {
        /**
         * @description Node data structure for List
         * @param parent parent node
         * @param child child node
         * @param value key value
         * @return
         * @author zczeng
         * @date 2020/2/29 20:08
         */
        this.parent = parent;
        this.child = child;
        this.value = value;
    }

    public ListNode parent;
    public ListNode child;
    public float value;
}