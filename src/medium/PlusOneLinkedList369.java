package medium;

public class PlusOneLinkedList369 {
    /**My reverse twice method*/
    public ListNode plusOne(ListNode head) {
        if(head == null) return null;
        ListNode tail = reverse(head), curr = tail, prev = null;
        while(curr != null) {
            if(curr.val != 9) {
                curr.val += 1;
                break;
            } else {
                curr.val = 0;
                prev = curr;
                curr = curr.next;
            }
        }
        if(curr == null) prev.next = new ListNode(1);
        return reverse(tail);
    }
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head, next;
        while(curr != null) {
            next = curr.next; //save
            curr.next = prev; //reverse
            prev = curr; //move back
            curr = next;
        }
        return prev;
    }
    /**Others O(n) method*/
    public ListNode plusOne2(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode i = fake;
        ListNode p = fake;
        while (p.next != null) {
            p = p.next;
            if (p.val != 9) {
                i = p;
            }
        }
        // i = index of last non-9 digit
        i.val++; //non-9 digit + 1
        i = i.next;
        while (i != null) { //set all 9 after i to be 0
            i.val = 0;
            i = i.next;
        }
        if (fake.val == 0) return fake.next;
        else return fake;
    }

}
