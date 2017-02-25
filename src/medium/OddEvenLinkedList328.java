package medium;

public class OddEvenLinkedList328 {
  //every time meet an odd, insert it to front
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode prevOdd = head, prevEven = head.next, firstEven = prevEven,
        currOdd = prevEven.next, nextEven = currOdd.next;
        while(prevEven != null && prevEven.next != null) {
            //reset values
            currOdd = prevEven.next;
            nextEven = currOdd.next;
            //insert
            prevEven.next = nextEven;
            prevOdd.next = currOdd;
            currOdd.next = firstEven;
            //move backwards
            prevOdd = currOdd;
            prevEven = nextEven;
        }
        return head;
    }
}
