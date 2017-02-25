package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The BFS method for this problem.
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 * @author Shiyun Huang
 */
public class BinaryTreeLevelOrderTraversalII107_2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
           return null;
       }
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       q.add(root);

       List<List<Integer>> res = new ArrayList<List<Integer>>();
       List<Integer> level; 
       while (!q.isEmpty()){
           System.out.println("***");
           int qSize = q.size();
           System.out.println("qSize " + qSize);
           level = new ArrayList<Integer>();
           for(int i = 0; i < qSize; i++){//loop old queue size time
               level.add(q.peek().val);//poll old queue element out into level 
               bfs(q);//add new elements into queue
           }

           res.add(0, level);//reverse the adding sequence
       }
       return res;
    }
    private void bfs(Queue<TreeNode> q){
        System.out.println("peek: " + q.peek().val);
        TreeNode v = q.poll();//because you poll here!!don't poll twice!
        if (v == null) return;
        if (v.left != null) {
            q.add(v.left);
        }
        if (v.right != null) {
            q.add(v.right);
        }
        System.out.println("bfs, size " + q.size());
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = n1.left = new TreeNode(9);
        TreeNode n3 = n1.right = new TreeNode(20);
        TreeNode n4 = n3.left = new TreeNode(15);
        TreeNode n5 = n3.right = new TreeNode(7);
        BinaryTreeLevelOrderTraversalII107_2 x = new BinaryTreeLevelOrderTraversalII107_2();
        List<List<Integer>> list = x.levelOrderBottom(n1);
        System.out.println(list);
    }

}
