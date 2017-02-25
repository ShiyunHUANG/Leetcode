package medium;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        //at least need to have 3 nodes to be reorder
        ListNode fast = head, slow = head, prevSlow;
        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //cut old connections!!!!!!!!
        ListNode temp = slow.next;
        slow.next = null;
        //set two vars for reverse
        prevSlow = temp;
        slow = prevSlow.next;
        prevSlow.next = null;//cut connection!!!!!!!!!
        //reverse the 2nd half of the list
        while(slow != null) {
            ListNode nextSlow = slow.next;
            //reverse
            slow.next = prevSlow;
            //move backwards
            prevSlow = slow;
            slow = nextSlow;
        }
        //merge two lists, head and prevSlow are the heads
        //head one may be 1 node longer
        ListNode x = head,  y = prevSlow, postX, postY;
        while(y != null) {
            //save next nodes
            postX = x.next;
            postY = y.next;
            //insert y into x
            x.next = y;
            y.next = postX;
            //move backwards
            x = postX;
            y = postY; 
        }
    }
    public static void main(String[] args) {
        ReorderList143 x = new ReorderList143();
        ListNode n1 = new ListNode(0);
        ListNode n2 = n1.next = new ListNode(1);
        ListNode n3 = n2.next = new ListNode(2);
        ListNode n4 = n3.next = new ListNode(3);
        ListNode n5 = n4.next = new ListNode(4);
        ListNode n6 = n5.next = new ListNode(5);
        x.reorderList(n1);
        ListNode c = n1;
        while(c != null) {
            System.out.println(c.val + " ");
            c = c.next;
        }
    }

}
