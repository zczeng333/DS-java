/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<Integer>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        int[] answer = new int[s.size()];
        int i = 0;
        while (!s.isEmpty()) {
            answer[i] = s.pop();
            i++;
        }
        return answer;
    }
}