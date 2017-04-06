package medium;

import java.util.Stack;

//dfs inorder traversal
//notice ALL nodes on the left should be smaller than ALL right, so BFS WON'T work
public class ValidateBinarySearchTree98 {
    //second
  //inorder traversal: left most => mid => right
    public boolean isValidBST4(TreeNode root) {
        Integer prev = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) { //don't forget ! before isEmpty()
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //root is null here
            // if (!stack.isEmpty()) {
                root = stack.pop();
                if (prev != null && root.val <= prev) return false;
                prev = root.val; //no else here
                root = root.right;
            // }
        }
        return true;
    }
    
    
    //add the node if not null
    //node moves left then right
    //compare this pop with previous pop
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Integer pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                System.out.println("push: " + root.val);
                root = root.left;
            }
            root = stack.pop();
            System.out.println("pop: " + root.val);
            if(pre != null && root.val <= pre) {
                System.out.println(root.val + " " + pre);
                return false;
            }
            pre = root.val; //not in else clause, either way pre needs to move 
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
