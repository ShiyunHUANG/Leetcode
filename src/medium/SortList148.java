package medium;

public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; //remember recurssion termination condition
        //break the list into two parts
        ListNode fast = head, slow = head, prevSlow = null;
        while(fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = null;
        // slow.next = null;//should be the one before curret slow's next is null
        //sort each part
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(slow);
        //merge two parts
        return merge(n1, n2);
    }
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode fake = new ListNode(0), curr = fake;
        while(n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                curr.next = n1;
                n1 = n1.next;
            } else {
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        if (n1 != null) curr.next = n1;
        else if (n2 != null) curr.next = n2;
        return fake.next;
    }
}
