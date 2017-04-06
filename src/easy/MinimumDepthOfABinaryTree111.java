package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfABinaryTree111 {
    //others DFS
    public static int minDepth3(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth3(root.right) + 1;
        if (root.right == null) return minDepth3(root.left) + 1;
        return Math.min(minDepth3(root.left),minDepth3(root.right)) + 1;
       }
    
    
    //second 4/5/2017
    public int minDepth2(TreeNode root) {
        //bfs
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int res = 1;
        int qsize = 1; //size of the queue, to determine which level is the tree
        while(!queue.isEmpty()) {
            for(int i = 0; i < qsize; i++) {
                TreeNode node = queue.remove();
                //BOTH left and right child are NULL is LEAF
                if (node.left == null && node.right == null) return res;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res++;
            qsize = queue.size();
        }
        return res;
    }
    
    
    //first
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//for BFS
        TreeNode curNode = root;
        int levelElements = 1;
        int depth = 1;
        while (curNode != null) {
            if(levelElements == 0) {
                depth++;//enter a new level, 2
                levelElements = queue.size()+1;//!!!
            }
            if(curNode.left == null && curNode.right == null) break;//!!!should be && not ||
            else {
                if(curNode.left!=null) queue.add(curNode.left);//!!! must have if
                if(curNode.right!=null) queue.add(curNode.right);
            }
            curNode = queue.poll();
            levelElements--;
        }
        return depth;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
