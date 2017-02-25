package medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> res = new  ArrayList<List<Integer>>();
        dfs(root, sum, path, res);
        return res;
    }
    private boolean dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return false;
        }
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                res.add(new ArrayList<Integer>(path));//must new one! because path is mutable.
                path.remove(path.size() - 1);
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }
        boolean b1 = dfs(node.left, sum - node.val, path, res);
        boolean b2 = dfs(node.right, sum - node.val, path, res);
        path.remove(path.size() - 1);
        return  b1 || b2; 
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
