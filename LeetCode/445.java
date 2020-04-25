/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int cy = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        ListNode start = null;//记录返回数组的开头节点
        ArrayList<Integer> num1 = new ArrayList<Integer>();
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        while (temp != null) {//l1中数值
            num1.add(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {//l2中数值
            num2.add(temp.val);
            temp = temp.next;
        }
        int i = num1.size() - 1;//记录两个数组较小的长度
        int j = num2.size() - 1;
        int sum;
        temp = null;
        while (i >= 0 || j >= 0 || cy != 0) {
            if (i >= 0 && j >= 0) {
                start = cal(temp, num1.get(i), num2.get(j));
                temp = start;
                i--;
                j--;
            } else if (i >= 0 && j < 0) {
                start = cal(temp, num1.get(i), 0);
                temp = start;
                i--;
            } else if (i < 0 && j >= 0) {
                start = cal(temp, 0, num2.get(j));
                temp = start;
                j--;
            } else {
                start = cal(temp, 0, 0);
                temp = start;
            }
        }
        return start;
    }

    public ListNode cal(ListNode temp, int n1, int n2) {
        int sum = n1 + n2 + cy;
        if (sum >= 10) {
            sum = sum - 10;
            cy = 1;
        } else {
            cy = 0;
        }
        ListNode start = new ListNode(sum);
        start.next = temp;
        return start;
    }
}