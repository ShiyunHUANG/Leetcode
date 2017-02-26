/*
 * Linked List. Tricky
 */
package Apple;
/**
 * Write a function to delete a node (except the tail)
 * in a singly linked list, given only access to that node. 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are
 * given the third node with value 3, the linked list should
 * become 1 -> 2 -> 4 after calling your function. 
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { 
         val = x;
     }
}
 
public class DeleteNodeInLinkedList237 {

    public void deleteNode(ListNode node) {
        ListNode next = node.next, next2 = next.next;
        node.val = next.val;
        node.next = next2;
    }
}
