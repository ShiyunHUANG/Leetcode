package easy;
/**
 * Could you do it in O(n) time and O(1) space?
 * @author Shiyun Huang
 */

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null||head.next==null) return true;
        /*
         * Count the length of this list
         */
        ListNode i = head;
        int length = 0;
        while(i!=null){
            length = length +1;
            i = i.next;
        }
        /*
         * Find the mid-point.
         * Odd length is middle, even length is the latter middle
         */
        ListNode mid = head;
        int count = 1;
        while(count<=length/2){
                mid = mid.next;
                count++;
        }
        System.out.println("mid "+mid.val);
        /*
         * reverse the first half, for odd length
         */
        ListNode preNode = head;
        ListNode currentNode = preNode.next;
        ListNode nextNode = currentNode.next;
        while(currentNode!=mid){
            currentNode.next = preNode;//point to head,count=0
            preNode = currentNode;
            currentNode = nextNode;
            nextNode =  currentNode.next;
        }
        /*
         * Check the first half and the second half
         */
        ListNode left = preNode;
        ListNode right;            
        if(length%2==1){
            right = nextNode;            
        }
        else{
            right = currentNode;
        }
        for(;;){
            System.out.println("left "+left.val+",right "+right.val);
            if(left.val!=right.val){
                return false;
            }
            else{
                if(left==head) break;
                left = left.next;
                right = right.next;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        ListNode n4 = n3.next = new ListNode(4);
        ListNode n5 = n4.next = new ListNode(3);
        ListNode n6 = n5.next = new ListNode(2);
        ListNode n7 = n6.next = new ListNode(1);
        boolean b1 = new PalindromeLinkedList234().isPalindrome(n1);
        System.out.println(b1);
        ListNode m1 = new ListNode(1);
        ListNode m2 = m1.next = new ListNode(2);
        ListNode m3 = m2.next = new ListNode(3);
        ListNode m4 = m3.next = new ListNode(3);
        ListNode m5 = m4.next = new ListNode(2);
        ListNode m6 = m5.next = new ListNode(1);
        boolean b2 = new PalindromeLinkedList234().isPalindrome(m1);
        System.out.println(b2);
    }

}
