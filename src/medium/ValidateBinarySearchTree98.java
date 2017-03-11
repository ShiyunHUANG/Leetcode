package medium;

import java.util.Stack;

//dfs inorder traversal
//notice ALL nodes on the left should be smaller than ALL right, so BFS WON'T work
public class ValidateBinarySearchTree98 {
    //add the node if not null
    //node moves left then right
    //compare this pop with previous pop
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.println("push: " + root.val);
                root = root.left;
            }
            root = stack.pop();
            System.out.println("pop: " + root.val);
            if(pre != null && root.val <= pre.val) {
                System.out.println(root.val + " " + pre.val);
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
    //recursive
    public boolean isValidBST3(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean dfs(TreeNode node, long min, long max) {
        if(node == null) return true;
        if(min >= node.val || max <= node.val) return false;   
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
    
    
    /**
     * My wrong method
    push: 3
    push: 2
    push: 1
    pop:1
    pop:2
    push: 1
    pop:1
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        stack.push(node);
        //find the leftmost
        TreeNode pre = null; //lastly poped
        while(!stack.isEmpty()) {
            while(node.left != null) {
                node = node.left;
                stack.push(node);
                System.out.println("push: " + node.val);
            }
            node = stack.pop(); //save this to be the next previous node
            System.out.println("pop:" + node.val);
            // if(stack.peek() != null) pre = stack.peek();

            if(pre != null && node.val <= pre.val) {
                System.out.println(node.val + " "+ pre.val);
                return false;
            }
            pre = node; //move nodes backwards
            if(node.right != null) {
                node = node.right;
                stack.push(node);
            }
        }

        return true;
    }
}
