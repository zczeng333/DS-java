/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;//最终走向尾结点
        ListNode p2 = head;//指向倒数第n+1个节点
        for (int i = 0; i < n && p1 != null; i++) {
            p1 = p1.next;
        }
        if (p1 == null) {
            return head.next;
        }//去除第一个节点
        while (p1.next != null) {//p1遍历到最后一个节点
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
    }
}