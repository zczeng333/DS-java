/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

//Solution 1: 将指针依次进栈，之后逐个弹出
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> s = new Stack<ListNode>();
        while (head != null) {
            s.push(head);
            head = head.next;
        }
        for (int i = 1; i < k; i++) {
            s.pop();
        }
        return s.pop();
    }
}

//Solution 2: 快慢指针
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}