package easy;

public class MergeTwoSortedLinkedList21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //merge l2 into l1
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null || node2 != null) {
            //connect the smaller node first.
            if (node1 == null || node1.val > node2.val) {
                prev.next = node2;
                node2 = node2.next;//go to the next node in l2
                prev = prev.next;//the new line go next too.
            } else if (node2 == null || node1.val <= node2.val) {
                prev.next = node1;
                node1 = node1.next;
                prev = prev.next;
            }
        }
        return fakeHead.next;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
