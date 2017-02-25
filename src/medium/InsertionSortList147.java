package medium;

public class InsertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode fake = new ListNode(Integer.MIN_VALUE);
        fake.next = head;
        ListNode prev = fake, curr = head, pos, prevPos;
        while(curr != null) {
            if(curr.val < prev.val) {
                prevPos = fake;
                pos = fake.next; //!!not head
                while(pos.val < curr.val) {
                    pos = pos.next;
                    prevPos = prevPos.next;
                }
                //remove curr from its current position
                prev.next = curr.next;
                //put curr in between prevPos and pos
                curr.next = pos;
                prevPos.next = curr;
                //move curr to next
                curr = prev.next;
            } else {
                curr = curr.next;
                prev = prev.next;                
            }
        }
        return fake.next;
    }
}
