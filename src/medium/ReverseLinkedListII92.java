package medium;
/**
 * Better print out the procedure!!!
 * @author Shiyun Huang
 *
 */
public class ReverseLinkedListII92 {
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode prevM, nodeM;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode curr = fakeHead;
        //locate the node before m
        int i = 1;
        while (i <= m - 1) {
            curr = curr.next;
            i++;
        }
        prevM = curr; //m node
        nodeM = curr.next;
        //locate the node after n, reverse nodes
        ListNode prev = curr, post = curr.next; //!!
        while (i <= n) { //curr node will be at position i
            prev = curr;
            curr = post;
            post = curr.next;
            //point to previous
            curr.next = prev;
            i++;
        }
        
        prevM.next = curr; //nodeN
        nodeM.next = post; //postN
        
        return fakeHead.next;
        
    }
    
    
    
    
    ListNode prev, post, node1, preNode1, node2, postNode2;//node 1 at m, node 2 is at n
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //head maybe reversed too, so make a fake head.
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        ListNode curr = head;
        int i = 1;
        while (i < m) {
            prev = prev.next;
            curr = curr.next;
            i++;
        }
        preNode1 = prev;//m - 1
        node1 = curr;//m
        // System.out.println(preNode1.val + " " + node1.val );
        // i = m
        while (i <= n && curr != null) {
            post = curr.next;
            curr.next = prev;
            // System.out.println(curr.val + " -> " + prev.val);
            //move backwards
            prev = curr;
            curr = post;
            i++;
        }
        //i = n
        node2 = prev;//n
        postNode2 = curr;//n + 1
        // System.out.println(postNode2.val + " " + node2.val );
        node1.next = postNode2; //m -> n + 1
        preNode1.next = node2; // m - 1 -> n
        return fake.next;
    }
}
