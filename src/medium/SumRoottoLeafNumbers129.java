package medium;

public class SumRoottoLeafNumbers129 {
    int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root, root.val);
        return res;
    }
    private void dfs(TreeNode node, int sum) {
        if(node.left == null && node.right == null) {
            res = res + sum;
            // System.out.println(sum);
            return;
        }
        if(node.left != null) {
            dfs(node.left, sum * 10 + node.left.val);
        } 
        if(node.right != null) {
            dfs(node.right, sum * 10 + node.right.val);
        }
    }
}
