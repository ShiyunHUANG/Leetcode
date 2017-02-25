package medium;

import java.util.Stack;

public class AddTwoNumbersII445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>(), stack2 = new Stack<Integer>(), nodes = new Stack<Integer>();
        ListNode n1 = l1, n2 = l2;
        while(n1 != null) {
            stack1.push(n1.val);
            n1 = n1.next;
        }
        while(n2 != null) {
            stack2.push(n2.val);
            n2 = n2.next;
        }
        int s1 = 0, s2 = 0, carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            s1 = stack1.isEmpty() ? 0 : stack1.pop();
            s2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = s1 + s2 + carry;
            nodes.push(sum % 10);
            carry = sum / 10;
        }
        ListNode dummy = new ListNode(0), curr = dummy;
        if(carry > 0) {
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        while(!nodes.isEmpty()) {
            curr.next = new ListNode(nodes.pop());
            curr = curr.next;
        }
        return dummy.next;
    }
}
