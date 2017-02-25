package hard;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode fake = new ListNode(0), curr = fake;
        boolean b = true;
        while(b) {
            b = false;
            List<Integer> minNodeIdx = new ArrayList<Integer>();
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < lists.length; i++) {
                ListNode n = lists[i];
                if(n == null) continue;
                if(n.val <= min) {
                    if(n.val < min) {
                        if(n != null) b = true;//this node won't be validate in else{}
                        minNodeIdx.clear();
                    }
                    minNodeIdx.add(i);
                    min = n.val;
                } else b = true;
            }
            for(Integer mn : minNodeIdx) {
                curr.next = lists[mn];//same as curr.next = new ListNode(lists[mn].val);
                curr = curr.next;
                //ListNode n = lists[mn]
                // n = n.next;//WRONG! n is local var
                lists[mn] = lists[mn].next;
                if(lists[mn] != null) b = true;
            }
        }
        return fake.next;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(-1), n2 = new ListNode(0), c1 = n1, c2 = n2;
        for(int i = 1; i < 6; i = i + 2) {
            c1.next = new ListNode(i);
            c2.next = new ListNode(i - 1);
            c1 = c1.next;
            c2 = c2.next;
        }
        MergeKSortedLists23 x = new MergeKSortedLists23();
        ListNode curr = x.mergeKLists(new ListNode[]{c1, c2});
        while(curr != null) {
            System.out.print(curr.val + " ");
        }
    }

}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
