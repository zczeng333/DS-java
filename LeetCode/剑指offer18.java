/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode temp = head;
        while (temp.next.val != val) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}