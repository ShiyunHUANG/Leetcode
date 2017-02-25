package medium;

public class RemoveDuplicatesFromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead, curr = fakeHead;
        while(curr != null) {
            // ======>
            if(curr == fakeHead || curr.next == null || curr.val != curr.next.val) {
                prev.next = curr.next;
                if(curr.next == null || curr.next.next == null 
                || curr.next.next.val != curr.next.val) prev = prev.next;//!!!
            }
            //  <=====
            //can be replace with this ====>
            if(prev.next == curr){//?two nodes with same val should not be ==!?
                prev = prev.next;
            }
            else{
                prev.next = curr.next;
            }
            // <======
            curr = curr.next;
        }
        return fakeHead.next;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
