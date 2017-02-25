package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * For example, the following two linked lists: 
A:          a1 → a2
                                                    ↘
                     c1 → c2 → c3
                                                    ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
 * Notes: 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns. 
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * @author Shiyun Huang
 */
public class IntersectionofTwoLinkedLists161 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        Set <ListNode> set = new HashSet<ListNode>();
        while (nodeA!=null){
            set.add(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB!=null){
           if(set.contains(nodeB))return nodeB;
           else nodeB = nodeB.next;
        }
        return null;
        
        /**
         * Just simply use HashSet...
         */
        
/*        ListNode nodeA = headA;
        ListNode nodeB = headB;
        ListNode tailA = headA;
        ListNode tailB = headB;
        
         * If the tail is not the same, then they don't intersect.
         
        while(nodeA.next!=null){
            tailA = tailA.next;
        }
        tailA.next = headA;
        while(nodeB.next!=null){
            tailB = tailB.next;
        } 
        if(tailA!=tailB) return null;
        
         * Put one list in Hashset.
         
        Set <ListNode> set = new HashSet<ListNode>();
        while (nodeA.next!=null){
            set.add(nodeA);
            nodeA = nodeA.next;
        }
        while (nodeB.next!=null){
           if(set.contains(nodeB))return nodeB;
           else nodeB = nodeB.next;
        }
        return null;*/
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
