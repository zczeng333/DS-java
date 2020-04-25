/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head, parent, front, temp;//parent记录上一个组倒序后的最后一个节点，p用于遍历list，front是新链表头
        LinkedList<ListNode> stack = new LinkedList<ListNode>();//栈用于存储k个ListNode
        int i;
        front = new ListNode();
        parent = front;
        while (true) {
            i = 0;
            while (p != null && i < k) {
                stack.add(p);
                p = p.next;
                i++;
            }//p此时指向下一次的开头位置
            if (i != k) {
                if (i != 0) {
                    parent.next = stack.element();
                } else {
                    parent.next = null;
                }
                break;
            }//List没有k个节点
            temp = stack.remove(k - 1);//栈顶元素出栈
            parent.next = temp;//将栈顶元素与parent相连
            while (stack.size() != 0) {//遍历整个栈
                temp.next = stack.remove(stack.size() - 1);//输出栈顶元素
                temp = temp.next;
            }
            parent = temp;
        }
        return front.next;
    }
}