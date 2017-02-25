package medium;

import java.util.Stack;

public class BinarySearchTreeIterator173 {
  //in order traversal
    TreeNode root;
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator173(TreeNode root) {
        this.root = root;
        stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null) {
            stack.add(curr);
            curr = curr.left; 
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop(), curr = res;
        if(curr.right != null) {
            curr = curr.right;
            stack.push(curr);
            while(curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            }
        }
        return res.val;
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */