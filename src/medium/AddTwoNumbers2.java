package medium;

public class AddTwoNumbers2 {
    /**My AC Solution, beat 85%*/
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode n1 = l1, n2 = l2;
        ListNode fakeHead = new ListNode(0), curr = fakeHead, prev = fakeHead;
        while (n1 != null && n2 != null) {
            curr = n1;
            n1.val = n1.val + n2.val + carry;
            if(carry > 0) carry--;
            if(n1.val > 9) {
                n1.val = n1.val - 10;
                carry++;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        while (n1 != null) {
            if(carry > 0) {
                n1.val = n1.val + carry;
                carry--;
                if(n1.val > 9) {
                    carry++;
                    n1.val = n1.val - 10;
                }
            }
            curr = n1;
            n1 = n1.next;
        }
        while (n2 != null) {
            curr.next = n2;
            if(carry > 0) {
                n2.val = n2.val + carry;
                carry--;
                if(n2.val > 9) {
                    carry++;
                    n2.val = n2.val - 10;
                }
            }
            curr = n2;
            n2 = n2.next;
        }
        if(carry > 0) curr.next = new ListNode(carry);
        return l1 == null ? l2 : l1;
    }
    /**My TLE Solution*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode n1 = l1, n2 = l2;
        boolean b1 = (n1 != null);
        boolean b2 = (n2 != null);
        ListNode fakeHead = new ListNode(0), curr = fakeHead;
        while(b1 || b2) {
            if(b1) {
                n1.val = n1.val + carry;
                if (carry > 0) carry--;
                if(b2) {
                    n1.val = n1.val + n2.val;
                    n2 = n2.next;
                }
                if(n1.val > 9) {
                    carry++;
                    n1.val = n1.val - 10;
                }
                curr.next = n1;
                curr = curr.next;
                n1 = n1.next;
            } else {
                n2.val = n2.val + carry;
                if (carry > 0) carry--;
                if(n2.val > 9) {
                    carry++;
                    n2.val = n2.val - 10;
                }
                curr.next = n2;
                curr = curr.next;
                n2 = n2.next;
            }
            b1 = (n1 != null);
            b2 = (n2 != null);
        }
        if(carry > 0) curr.next = new ListNode(carry);
        return l1 == null ? l2 : l1;
    }
}
