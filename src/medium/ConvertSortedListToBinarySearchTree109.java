package medium;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree109 {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<Integer>();
        while(node != null) {
            list.add(node.val);
            node = node.next;
        }
        return dfs(0, list.size() - 1, list, null, true);
    }
    /**Fast solution by others*/
    // this part is inside the upper method
    //    if(head==null) return null;
    //    return toBST(head,null);

    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode treehead = new TreeNode(slow.val);
        treehead.left = toBST(head,slow);
        treehead.right = toBST(slow.next,tail);
        return treehead;
    }
    /**My Solution, slow*/
    private TreeNode dfs(int lo, int hi, List<Integer> list, TreeNode root, boolean leftChild) {
        if(lo > hi) return null;//termination condition
        int mid = (lo + hi) / 2;
        TreeNode tn = new TreeNode(list.get(mid));
        if(root != null) {
            if(leftChild) root.left = tn;//originally wrote tn = root.left =_=
            else root.right = tn;
        }
        if(lo == hi) return tn;
        dfs(lo, mid - 1, list, tn, true);
        dfs(mid + 1, hi, list, tn, false);
        return tn;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
