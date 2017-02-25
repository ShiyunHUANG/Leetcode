package easy;

public class RemoveLinkedListElement203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead =  new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head;
        ListNode prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {//if this is the one to remove
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return fakeHead.next;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        ListNode n4 = n3.next = new ListNode(1);
        ListNode n5 = n4.next = new ListNode(5);
        RemoveLinkedListElement203 x = new RemoveLinkedListElement203();
        x.removeElements(n1, 1);
        
    }

}
