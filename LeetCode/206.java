/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){return head;}
    	ListNode p1=head;
    	ListNode p2=head.next;
    	ListNode temp;
    	while(p2!=null){
    		temp=p2.next;
    		p2.next=p1;
    		p1=p2;
    		p2=temp;
    	}
    	head.next=null;
    	return p1;
    }
}