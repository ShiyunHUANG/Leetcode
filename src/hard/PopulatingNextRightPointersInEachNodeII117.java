package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class PopulatingNextRightPointersInEachNodeII117 {
    /**My Queue method, beat 6%...*/
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>(); //queue
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeLinkNode node = q.remove(); //remove the head
                if(i != size - 1) node.next = q.peek(); //look at the first
                if(node.left != null) q.add(node.left); //add to end
                if(node.right != null) q.add(node.right); 
            }
        }
    }
}
