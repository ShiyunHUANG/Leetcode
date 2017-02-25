package medium;

public class CountUnivalueSubtrees250 {
    //beat 19%
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return res;
        if(dfs(root.val, root.left) & dfs(root.val, root.right)) res++;
        return res;
    }
    private boolean dfs(int target, TreeNode node) {
        if(node == null) return true;
        if(node.val != target) {
            if(dfs(node.val, node.left) & dfs(node.val, node.right)) {
                // System.out.println("target " + target + " node.val " + node.val);
                res++;
            }
            return false;
        } else {
            if(dfs(target, node.left) & dfs(target, node.right)) {
                // System.out.println("target " + target + " node.val " + node.val);
                res++;
                return true;//!!!
            }
            return false;//!!! NOT DIRECTLY RETURN TRUE HERE
        }
    }
}
