package medium;

import java.util.Stack;

public class KthSmallestElementInBST230 {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        int res = curr.val;
        // stack.push(curr);
        for (int i = 0; i < k;) {
            // System.out.println("i " + i + " curr " + curr.val + " size " + stack.size());
            while (curr.left != null) {
                stack.push(curr);
                curr = curr.left;
            }
            res = curr.val;
            i++;
            while (curr.right == null && i < k) {
                curr = stack.pop();//back to the closest parent that has not been visited.
                res = curr.val;
                i++;
            }
            if (curr.right != null) {
                curr = curr.right;//curr go to the right, it will be add in "mid"
                // stack.push(curr);                
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
