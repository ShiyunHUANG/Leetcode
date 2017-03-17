package medium;

import java.util.Stack;

public class BinaryTreeUpsideDown156 {
    //beat 1.17%...
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        //push into stack
        Stack<Integer> leftNodes = new Stack<Integer>();
        Stack<Integer> rightNodes = new Stack<Integer>();
        while(root != null) {
            leftNodes.push(root.val);
            if(root.right == null) rightNodes.push(null);
            else rightNodes.push(root.right.val);
            root = root.left;
        }
        //pop
        TreeNode fake = new TreeNode(0);
        TreeNode curr = fake;
        while(!leftNodes.isEmpty()) {
            Integer right = rightNodes.pop();
            if(right != null) curr.left = new TreeNode(right);
            curr.right = new TreeNode(leftNodes.pop());
            curr = curr.right;
        }
        return fake.right;
    }
}
