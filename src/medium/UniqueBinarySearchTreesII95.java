package medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return dfs(1, n);
    }
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>(), 
        leftChild = new ArrayList<TreeNode>(),
        rightChild = new ArrayList<TreeNode>();
        if(start > end) {
            res.add(null);
            return res;
        }
        //wrong loop!
        /*for(int i = start; i <= end; i++) {
            TreeNode root = new TreeNode(i);
            leftChild = dfs(start, i - 1);
            rightChild = dfs(i + 1, end);
            for(TreeNode lc : leftChild) {
                root.left = lc;
                for(TreeNode rc : rightChild) {
                    root.right = rc;
                    res.add(root.val);
                }
            }
        }*/
        for(int i = start; i <= end; i++) {
            leftChild = dfs(start, i - 1);
            rightChild = dfs(i + 1, end);
            for(TreeNode lc : leftChild) {
                for(TreeNode rc : rightChild) {
                    TreeNode root = new TreeNode(i);//need to be in here, but why?
                    root.left = lc;
                    root.right = rc;
                    res.add(root);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
