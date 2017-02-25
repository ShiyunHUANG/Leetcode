package medium;

public class PartitionList83 {
    public ListNode partition(ListNode head, int x) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead, curr = head;//This linkedlist
        ListNode xtraHead = new ListNode(0);
        ListNode xtra = xtraHead;
        while(curr != null) {
            if(curr.val >= x) {
                prev.next = curr.next;//remove node in list
                xtra.next = curr;//add node in xtra list
                curr.next = null;
                curr = prev.next;
                xtra = xtra.next;
            } else {
                prev = prev.next;//!!
                curr = curr.next;
            }
        }
        //curr == null now
        prev.next = xtraHead.next;//join two lists
        return fakeHead.next;
    }
}
