package easy;

public class SwapNodesinPairs24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode temp = curr.next;
            //swap
            curr.next = curr.next.next;
            temp.next = curr;
            prev.next = temp;
            //go to the next pair
            prev = curr;
            curr = curr.next;            
        }
        return head.next;
    }
    public static void main(String[] args) {
        SwapNodesinPairs24 x = new SwapNodesinPairs24();
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        ListNode n4 = n3.next = new ListNode(4);
        ListNode n5 = n4.next = new ListNode(5);
        ListNode n6 = n5.next = new ListNode(6);
        ListNode n7 = n6.next = new ListNode(7);
        x.swapPairs(n1);
        System.out.println("*****\n" + n1.next.val);
        System.out.println(n2.next.val);
        System.out.println(n3.next.val);
        System.out.println(n4.next.val);
        System.out.println(n5.next.val);
        System.out.println(n6.next.val);
        System.out.println(n7.next.val);
    }

}
