package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * for a singly-linked list
 * @author Shiyun Huang
 *
 */
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;
        Map<Integer, ArrayList> map = new HashMap<Integer, ArrayList>();
        while(nextNode!=null){
            if(!map.containsKey(currentNode.val)){
                ArrayList<ListNode> arr = new ArrayList<ListNode>();
                arr.add(currentNode);
                map.put(currentNode.val, arr);
            }
            else map.get(currentNode.val).add(currentNode);
            if(nextNode.next!=null&&map.containsKey(nextNode.next.val)){
                for(int i = 0; i<map.get(nextNode.next.val).size();i++){
                    if(nextNode.next.equals(map.get(nextNode.next.val).get(i))){
                        return true;
                    }
                }
            }
            currentNode = nextNode;
            nextNode = currentNode.next;
        }
        return false;
        
        
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        ListNode n4 = n3.next = new ListNode(4);
        n4.next = n2;
//        n4.next = n1;
        boolean b = new LinkedListCycle141().hasCycle(n1);
        System.out.println(b);
    }

}
