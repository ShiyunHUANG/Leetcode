package medium;

public class LinkedListCycleII142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while(true) {
            slow = slow.next;
            if(fast.next == null) return null;
            fast = fast.next.next;
            if(fast == null) return null;
            if(fast == slow) break;
        }
        ListNode newSlow = head;
        while(newSlow != slow) {
            newSlow = newSlow.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(2);
//        ListNode n3 = n2.next = new ListNode(3);
//        ListNode n4 = n3.next = new ListNode(4);
        n2.next = n1;
        LinkedListCycleII142 x = new LinkedListCycleII142();
        System.out.println(x.detectCycle(n1).val);
    }
}
