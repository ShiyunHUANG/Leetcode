package AmazonOA;
/**
Given two binary trees s and t, check if t is a subtree of s. A subtree of a tree t is a tree consisting of a node in t and all of its descendants in t.

Example 1:

Given s:

     3
    / \
   4   5
  / \
 1   2

Given t:

   4 
  / \
 1   2
Return true, because t is a subtree of s.

Example 2:

Given s:

     3
    / \
   4   5
  / \
 1   2
    /
   0

Given t:

     3
    /
   4
  / \
 1   2
Return false, because even though t is part of s, it does not contain all descendants of t.

Follow up:
What if one tree is significantly lager than the other?

 */
public class isSubtree {
    //use bfs to search through the nodes and use dfs to compare if subtree
    boolean isSub(TreeNode root, TreeNode sroot) {
        if(root == null || sroot == null) return false;
        if(root.val == sroot.val && isSame(root, sroot)) return true;
        return isSub(root.left, sroot) || isSub(root.right, sroot);
    }
    boolean isSame(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val == node2.val) {
            return isSame(node1.left, node2.left) && isSame(node1.right, node2.right);
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
