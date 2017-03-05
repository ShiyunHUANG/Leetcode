package AmazonOA;
//easy
/**
 * Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.
 * Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   3 -4  -5 

return the node with value 3.

 */
public class _MaximumSubtree {
    /**
     * @param root the root of binary tree
     * @return the maximum weight node
     */
    private TreeNode maxNode = null;
    private int max = Integer.MIN_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        return maxNode;
    }
    private int dfs(TreeNode node) {
        if(node == null) return 0;
        int sum = node.val + dfs(node.left) + dfs(node.right);
        if(sum > max) {
            maxNode = node;
            max = sum;
        }
        return sum;
    }
}


class TreeNode {
    public TreeNode(int x){
        val = x;
    }
    TreeNode left;
    TreeNode right;
    int val;
}