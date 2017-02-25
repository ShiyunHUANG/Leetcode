package medium;

public class HouseRobberIII337 {
    /**Others greedy solution DP, beat 50%*/
    public int rob2(TreeNode root) {
        int[] res = dfs2(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs2(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = dfs2(root.left);
        int[] right = dfs2(root.right);
        int[] res = new int[2];
        //not rob this one
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //rob this one
        res[1] = root.val + left[0] + right[0];
        return res;
    }
    
    
    /**
     * My DFS Method, no need to pass parameter "sum" and "max" in the dfs(). Beat 11%
     */
    public int rob(TreeNode root) {
        return dfs(root, true);
    }
    private int dfs(TreeNode curr, boolean canRob) {
        if(curr == null) return 0;
        if(!canRob) {
            return dfs(curr.left, true) + dfs(curr.right, true);
        } else {
            //don't rob this one
            int tmp1 = dfs(curr.left, true) + dfs(curr.right, true);
            //rob this one
            int tmp2 = curr.val + dfs(curr.left, false) + dfs(curr.right, false);
            return Math.max(tmp1, tmp2);
        }
    }
}
