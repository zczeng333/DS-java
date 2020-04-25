/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    static Comparator<ListNode> cmp = new Comparator<ListNode>() {
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;//小顶堆
        }
    };

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        ListNode front = new ListNode();//新链表首部
        ListNode rear = front;//记录新链表的尾部
        ListNode temp;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.add(lists[i]);//将每个list的第一个元素压入小顶堆中
            }
        }
        while (q.size() != 0) {
            rear.next = new ListNode();
            rear = rear.next;
            temp = q.remove();
            rear.val = temp.val;
            if (temp.next != null) {
                q.add(temp.next);
            }
        }
        return front.next;
    }
}