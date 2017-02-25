package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is height-balanced. 
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of every
 * node never differ by more than 1. 
 * @author Shiyun Huang
 *
 */
public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int leftDepth = depth(root.left);
        int  rightDepth = depth(root.right);
        int balanceFactor = Math.abs(rightDepth-leftDepth);
        while(balanceFactor <= 1 ){
            
        }
        return false;
    }
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
    public static void main(String[] args) {

    }

}
