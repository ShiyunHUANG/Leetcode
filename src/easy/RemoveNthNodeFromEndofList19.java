package easy;

public class RemoveNthNodeFromEndofList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next =head;
        ListNode fast = newHead;
        ListNode slow = newHead;//the one before the delete one.
        for (int i = 0; i <= n; i++) {//the gap
            fast = fast.next;
        }
        while (fast != null) {//not fast.next, when fast == null, below won't run and slow remain the former one
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
    public static void main(String[] args) {

    }

}
