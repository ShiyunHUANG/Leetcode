package medium;
//In a complete binary tree every level, except possibly the last,
//is completely filled, and all nodes in the last level are as far left as possible.
public class CountCompleteTreeNodes222 {
    /**Recursion method, beat 24%*/
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root, false);
        int right = depth(root, true);
        if(left == right) return (1 << left) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int depth(TreeNode node, boolean right) {
        int dep = 0;
        if(node == null) return dep;
        if(right) {
            while(node != null) {
                node = node.right;
                dep++;
            }
        } else {
            while(node != null) {
                node = node.left;
                dep++;
            }
        }
        return dep;
    }
}
