package easy;

import java.util.ArrayList;
import java.util.List;
/**
 * Another way to do this is to use similar method as "Same Tree", check each node.

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null ^ right == null) return false;
        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


 */
public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        List<Integer> pathR = new ArrayList<Integer>();
        List<Integer> pathL = new ArrayList<Integer>();
        dfsR(root, pathR);
        dfsL(root,pathL);
        return pathR.equals(pathL);
    }
    private void dfsR(TreeNode node, List<Integer> path) {
        if (node == null) {
            path.add(-1);
            return;
        }
        path.add(node.val);
        dfsR(node.right, path);
        dfsR(node.left, path);
    }
    private void dfsL(TreeNode node, List<Integer> path) {
        if (node == null) {
            path.add(-1);
            return;
        }
        path.add(node.val);
        dfsL(node.left, path);
        dfsL(node.right, path);
    }
    public static void main(String[] args) {
    }

}
