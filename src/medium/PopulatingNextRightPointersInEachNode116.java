package medium;

import java.util.LinkedList;
import java.util.Queue;

// Definition for binary tree with next pointer.
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersInEachNode116 {
    /**Others 2 pointers*/
    public void connect2(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while(levelStart != null) { 
            TreeLinkNode curr = levelStart;
            while(curr != null) {
                if(curr.left != null) curr.left.next = curr.right;
                if(curr.right != null && curr.next!=null) curr.right.next = curr.next.left; //!!!remember && cur.next!=null
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }
    /**BFS*/
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        while(!q.isEmpty()) { 
            int bound = q.size();
            for(int i = 0; i < bound; i++) {
                TreeLinkNode curr = q.remove();
                if(i == bound - 1) curr.next = null;//!!! the condition 
                else curr.next = q.peek();
                if(curr.left != null) { //assume to be perfect tree so has 2 children 
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode116 x = new PopulatingNextRightPointersInEachNode116();
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = n1.left = new TreeLinkNode(2);
        TreeLinkNode n3 = n1.right = new TreeLinkNode(3);
        TreeLinkNode curr = n1;
        System.out.println("curr " + curr.val + " curr.left " + 
                curr.left.val + " curr.right " + curr.right.val);
        System.out.println("curr.left " + curr.left.val + " -> " + " curr.right " + curr.right.val);
        System.out.println("curr " + curr.val + " -> " + curr.next);
    }
}
