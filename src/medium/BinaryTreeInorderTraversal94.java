package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * left-mid-right
 * Nor recursive method, use stack.
 * @author Shiyun Huang
 *
 */
public class BinaryTreeInorderTraversal94 {
    //second
    //inorder: left => mid => right
    private List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal2(TreeNode root) {
        // dfs(root);
        loop(root);
        return list;
    }
    //recursive solution
    private void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
    //iterative solution
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private void loop(TreeNode node) {
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right; //don't need to check if node is null, don't need to push into stack
        }
    }










    //first
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = root;
        while (currentNode != null) {
            stack.push(currentNode);
            //find the left most node. When end, currentNode is not null.
            while (currentNode.left != null) {
                currentNode = currentNode.left;
                stack.push(currentNode);
            }
            //add the remove left most val
            res.add(stack.pop().val);
            System.out.println(currentNode.right==null);
            //if no right node, go up. 
            while (currentNode.right == null && !stack.isEmpty()) {
                currentNode = stack.pop();
            }
            res.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = n1.left = new TreeNode(2);
        TreeNode n3 = n1.right = new TreeNode(3);
        TreeNode n4 = n2.left = new TreeNode(4);
        TreeNode n5 = n2.right = new TreeNode(5);
        TreeNode n6 = n3.right = new TreeNode(6);
        TreeNode n7 = n5.right = new TreeNode(7);
        TreeNode n8 = n7.right = new TreeNode(8);
        TreeNode n9 = n6.right = new TreeNode(9);
        BinaryTreeInorderTraversal94 x = new BinaryTreeInorderTraversal94();
        System.out.println(x.inorderTraversal(n1));
    }

}
