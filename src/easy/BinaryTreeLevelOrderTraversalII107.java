package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
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
public class BinaryTreeLevelOrderTraversalII107 {
    //2/4/2017
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;//!!!
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int size = 1;
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                level.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            size = q.size();
            res.add(0, level); //add to the head
        }
        return res;
    }
    
    /*
    * the main idea is to search from the root, store the nodes of the same rank in 
    * an ArrayList and use that for the reference of the next rank.
    */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        //whole is the result ArrayList of TreeNode type.
        List<List<TreeNode>> whole = new ArrayList<List<TreeNode>>();
        //level represents each rank level of whole.
        List<TreeNode> level = new ArrayList<TreeNode>();
        //level begins from root.
        level.add(root);
        //newLevel is the next rank of level.
        List<TreeNode> newLevel = new ArrayList<TreeNode>();
        while(!level.isEmpty()){//!!! use isEmpty() , not null
            whole.add(level);
            for(TreeNode node : level){
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left!=null) newLevel.add(left);
                if(right!=null) newLevel.add(right);
            }
            level = newLevel;
            newLevel = new ArrayList<TreeNode>();
        }
        return getReverseNodeValue(whole);
    }
    /*
    * The following method will turn the TreeNode type ArrayList to Integer value type ArrayList.
    */
    private List<List<Integer>> getReverseNodeValue(List<List<TreeNode>> whole){
        if(whole.isEmpty()) return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //The following loop reverse the rank order in BST "whole".
        for(int i = whole.size() - 1; i >= 0; i--){
            List<Integer> resElement = new ArrayList<Integer>();
            //Loop through a rank to get all the elements from left to right.
            for(int j = 0; j < whole.get(i).size(); j++){
                resElement.add(whole.get(i).get(j).val);
            }
            res.add(resElement);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = n1.left = new TreeNode(9);
        TreeNode n3 = n1.right = new TreeNode(20);
        TreeNode n4 = n3.left = new TreeNode(15);
        TreeNode n5 = n3.right = new TreeNode(7);
        List<List<Integer>> list = new BinaryTreeLevelOrderTraversalII107().levelOrderBottom(n1);
        System.out.println(list);
    }

}
