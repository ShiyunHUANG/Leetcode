package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    private List<Integer> recurList = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //mid-left-right
        // return iterative(root);
        dfs(root);
        return recurList;
        
        
    }
    //iterative beat 37%
    private List<Integer> iterative(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return res;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //root is null here
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
    
    //recursive best 37%
    private void dfs(TreeNode root) {
        if (root == null) return;
        recurList.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
