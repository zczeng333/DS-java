/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode front = head.next;//新数组的首指针
        ListNode temp = head;//用于遍历数组
        ListNode parent = null;//temp节点的父节点
        while (temp != null && temp.next != null) {//当至少还剩两个节点时
            swap(parent, temp, temp.next);
            parent = temp;
            temp = temp.next;//注意这里已经交换过了，所以temp.next应当是交换前的temp.next.next
        }
        return front;
    }

    public void swap(ListNode parent, ListNode n1, ListNode n2) {//交换节点n1与n2
        n1.next = n2.next;
        n2.next = n1;
        if (parent != null) {
            parent.next = n2;
        }
    }
}