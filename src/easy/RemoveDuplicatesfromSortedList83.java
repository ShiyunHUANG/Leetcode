package easy;

public class RemoveDuplicatesfromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode currentN = head;
        ListNode nextN = currentN.next;
        while(nextN != null) {
            if(currentN.val == nextN.val) {
                currentN.next = nextN.next;
                nextN = nextN.next;
            }
            else {
                currentN = currentN.next;
                nextN = currentN.next;
            }
        }
        return head;//??
    }
    /*public ListNode deleteDuplicates(ListNode currentNode) {
        if(currentNode == null) return null;
        ListNode nextNode = currentNode.next;
        System.out.println("currentNode " + currentNode.val + " nextNode " + nextNode.val);
        while(currentNode.val == nextNode.val) {
            System.out.println(currentNode.val == nextNode.val);
            currentNode.next = nextNode.next;
            nextNode = nextNode.next;
            System.out.println("currentNode " + currentNode.val + " nextNode " + nextNode);
            if(nextNode == null) break;
        }
        if(nextNode != null) {
                currentNode = nextNode;//these two lines 
                System.out.println("currentNode " + currentNode.val);  
                System.out.println(" nextNode " + nextNode.val);
                nextNode = nextNode.next;// should not be reversed....!!!  
        }
        return currentNode;

    }*/
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = n1.next = new ListNode(1);
        ListNode n3 = n2.next = new ListNode(1);
        ListNode n4 = n3.next = new ListNode(1);
        ListNode n5 = n4.next = new ListNode(1);
        ListNode n6 = n5.next = new ListNode(2);
        ListNode n7 = n6.next = new ListNode(3);
        ListNode n8 = n7.next = new ListNode(3);
        new RemoveDuplicatesfromSortedList83().deleteDuplicates(n1);
        for(ListNode n = n1; n != null; n = n.next){
            System.out.print(n.val + "\t");
        }
    }

}
