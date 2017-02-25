package easy;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList206 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode;
        ListNode preNode = null;
        while (currentNode!=null){
            nextNode = currentNode.next;
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
            System.out.println(preNode.val);
        }
        return preNode;//not currentNode
        
/*        ListNode temp = head;
        ListNode temp2;
        while(temp!=null){
            temp2 = temp;
            temp2.next.next = temp;
            temp = temp.next;
        }
        return head;*/
        /**
         * Out of time limit
         */
        /*List<ListNode> list = new ArrayList<ListNode>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp);
            temp = temp.next;
        }
        for(int i=list.size()-1;i>0;i--){
            list.get(i).next=list.get(i-1);
        }
        return head;*/
        
        
/*        if(head==null||head.next==null) return null;
        ListNode node1 = head;//node1 is the input node
        System.out.println("node1 "+node1.val);
        ListNode temp1 = node1.next;//temp1: original list node2 copy
        ListNode node2 = new ListNode(temp1.val);
        System.out.println("node2 "+node2.val + "node2.next " + node2.next);
        //if(node2.next==null) return node1;
        //ListNode temp = node2;//store the next node of node2. Maybe null.
        //System.out.println("temp "+temp.val);
        node2.next = node1;// point back
        head.next = node2;
        return reverseList(temp1);//go to the next node. Maybe null.
*/        
        /**
         * the following becomes recurring results.
         */
        /*ListNode node1 = head;
        if(node1==null||node1.next==null)return node1;
        ListNode node2;
        ListNode temp;
        while(node1!=null){
            node2 = node1.next;//assign node2 to be the next node of node1.
            if(node2==null){
                return node1;
            }
            temp = node2.next;//store the next node of node2. Maybe null.
            node2.next = node1;//point back. Not null.
            node1 = temp;//go to the next node. Maybe null.
        }
        return node1;*/
        /**
         * StackOverFlowError for the following method.
         */
/*        if(head.next!=null&&head!=null){
            head.next.next=head;
        }
        else return null;
        return reverseList(head.next);*/
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        ListNode n4 = n3.next = new ListNode(4);
        new ReverseLinkedList206().reverseList(n1);
        System.out.println(n1.val + " " + n2.val + " " + n3.val + " " + n4.val);
//        System.out.println(n4.val+" "+n4.next.val + " " + n4.next.next.val + " " + n2.next.val);
//        System.out.println(n2.val + " " + n2.next.val);
        System.out.println(new ReverseLinkedList206().reverseList(n1).val);
        
    }

}
