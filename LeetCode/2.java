/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cy = 0;
        int sum;
        ListNode start = new ListNode();
        ListNode temp = start;
        ListNode forward = start;
        while (l1 != null && l2 != null) {//遍历到最后一个元素
            sum = l1.val + l2.val + cy;
            if (sum > 9) {
                cy = 1;
                temp.val = sum - 10;
            } else {
                temp.val = sum;
                cy = 0;
            }
            temp.next = new ListNode();
            forward = temp;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null) {//l1遍历到了尽头
            while (l2 != null) {
                sum = l2.val + cy;
                if (sum > 9) {
                    cy = 1;
                    temp.val = sum - 10;
                } else {
                    temp.val = sum;
                    cy = 0;
                }
                temp.next = new ListNode();
                forward = temp;
                temp = temp.next;
                l2 = l2.next;
            }
        } else if (l2 == null) {
            while (l1 != null) {
                sum = l1.val + cy;
                if (sum > 9) {
                    cy = 1;
                    temp.val = sum - 10;
                } else {
                    temp.val = sum;
                    cy = 0;
                }
                temp.next = new ListNode();
                forward = temp;
                temp = temp.next;
                l1 = l1.next;
            }
        }
        if (cy == 1) {
            temp.val = 1;
        } else {
            forward.next = null;
        }
        return start;
    }
}