import java.util.Vector;
import java.util.Enumeration;

public class ListOperation {
    public static ListNode head; /*head node of List*/

    public ListOperation(ListNode head, float[] args) {
        /**
         * @description Set up List data structure based on input int array args
         * @param head head node of List (When data is represented as list)
         * @param args input int array (When data is represented as array)
         * @return
         * @author zczeng
         * @date 2020/2/29 20:08
         */
        if (head == null) {
            if (args == null) {
                System.out.println("Invalid Input");
            } else {
                this.head = new ListNode(null, null, 0);
                ListNode temp = this.head;
                for (int i = 0; i < args.length; i++) {
                    ListNode node = new ListNode(temp, null, args[i]);
                    temp.child = node;
                    temp = node;
                }
            }
        } else {
            this.head = head;
        }
    }

    public int length() {
        /**
         * @description get length of list
         * @param
         * @return int length of list
         * @author zczeng
         * @date 2020/2/29 20:11
         */
        ListNode temp = this.head;
        int length = 0;   /*head is not count in length*/
        while (temp.child != null) {/*while not leave*/
            temp = temp.child;
            length = length + 1;
        }
        return length;
    }

    public void print_list() {
        /**
         * @description print object List
         * @param
         * @return void
         * @author zczeng
         * @date 2020/2/29 20:11
         */
        ListNode temp = this.head.child;
        Vector record = new Vector();
        while (temp != null) {
            record.add(temp.value);
            temp = temp.child;
        }
        System.out.print("List: ");
        Enumeration enu = record.elements();
        System.out.print("[");
        while (enu.hasMoreElements()) {
            System.out.printf("%.2f ", (float) enu.nextElement());
        }
        System.out.println("]");
    }

    public ListNode find(int ind) {
        /**
         * @description find ListNode with specific index "ind"
         * @param ind index to find
         * @return ListNode ListNode found
         * @author zczeng
         * @date 2020/2/29 20:11
         */
        ListNode temp = this.head.child;
        int i = 0;
        while (i < ind) {
            if (temp.child == null) {/*index out of range*/
                System.out.println("Index out of range!");
                return null;
            }
            temp = temp.child;
            i = i + 1;
        }
        return temp;
    }

    public void insert(ListNode insert_node, int ind) {
        /**
         * @description Insert ListNode into existing list
         * @param insert_node ListNode to be inserted
         * @param ind index to insert ListNode
         * @return void
         * @author zczeng
         * @date 2020/2/29 20:12
         */
        ListNode temp = find(ind - 1);  /*find the (ind-1)th node*/
        if (temp == null) {
            System.out.println("Unable to insert!");
        } else {
            insert_node.child = temp.child;
            insert_node.child.parent = insert_node;
            insert_node.parent = temp;
            temp.child = insert_node;
        }
    }

    public void delete(int ind) {
        /**
         * @description delete specific ListNode
         * @param ind index of ListNode to be deleted
         * @return void
         * @author zczeng
         * @date 2020/2/29 20:13
         */
        ListNode temp = find(ind);/*node to be deleted*/
        if (temp.child == null) {/*leave*/
            temp.parent.child = null;
        } else {
            temp.parent.child = temp.child;
            temp.child.parent = temp.parent;
        }
    }
}