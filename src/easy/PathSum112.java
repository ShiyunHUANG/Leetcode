package easy;

import java.util.ArrayList;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) return true;
            else return false;
        }
        int res = root.val;
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(root.left, sum, res, list);            
        dfs(root.right, sum, res, list);            
        for (int i : list) {
            if (i == sum) {
                return true;
            }
        }
        return false;
    }
    private void dfs (TreeNode node, int sum, int res, ArrayList<Integer> list) {
        if(node == null) {
            return;
        }
        res = res + node.val;
        if (node.left == null && node.right == null) {
            list.add(res);
            // System.out.println(list);
        }
        // System.out.println("res = " + res);
        dfs(node.left, sum, res, list);
        dfs(node.right, sum, res, list);
        res = res - node.val;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
