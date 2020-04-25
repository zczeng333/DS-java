/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode start = new ListNode();
        if (p1.val < p2.val) {
            start.val = p1.val;
            p1 = p1.next;
        } else {
            start.val = p2.val;
            p2 = p2.next;
        }
        ListNode temp = start;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                while (p2 != null) {
                    temp.next = new ListNode();
                    temp = temp.next;
                    temp.val = p2.val;
                    p2 = p2.next;
                }
            } else if (p2 == null) {
                while (p1 != null) {
                    temp.next = new ListNode();
                    temp = temp.next;
                    temp.val = p1.val;
                    p1 = p1.next;
                }
            } else {
                if (p1.val < p2.val) {
                    temp.next = new ListNode();
                    temp = temp.next;
                    temp.val = p1.val;
                    p1 = p1.next;
                } else {
                    temp.next = new ListNode();
                    temp = temp.next;
                    temp.val = p2.val;
                    p2 = p2.next;
                }
            }
        }
        return start;
    }
}