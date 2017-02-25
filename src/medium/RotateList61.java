package medium;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode curr = head;
        int count = 1;//at least one node.
        //first count the total
        for (int i = 0; curr.next != null; i++) {
            curr = curr.next;
            count++;
        }
        // System.out.println(count + " " + curr.val + " " + newTail.val);
        //Now, curr is tail. Make a circle.
        curr.next = head;
        //back to beginning
        curr = head;
        k = k % count; //in case k is more than count
        // new tail is at count - k, start counting at 1.
        for (int i = 1; i < count - k; i++) {
            curr = curr.next;
        }
        ListNode newTail = curr;
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
