package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfABinaryTree111 {

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
