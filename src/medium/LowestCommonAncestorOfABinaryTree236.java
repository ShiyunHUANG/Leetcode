package medium;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTree236 {
    /**My DFS solution, beat 11%*/
    List<TreeNode> path1, path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        path1 = new ArrayList<TreeNode>();
        path2 = new ArrayList<TreeNode>();
        dfs(root, p, q, new ArrayList<TreeNode>());
        TreeNode res = root;
        for(int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if(path1.get(i) == path2.get(i)) res = path1.get(i);
            else break;
        }
        return res;
    }
    private void dfs(TreeNode curr, TreeNode target1, TreeNode target2, List<TreeNode> path) {
        path.add(curr);
        if(curr == target1) {
            path1 = new ArrayList<TreeNode>(path);
//            return;//DONT RETURN AFTER CURR == TARGET NODE, WON'T GO DOWN ANYMORE!!!!!!!!
        }
        if(curr == target2) {
            path2 = new ArrayList<TreeNode>(path);
//            return;
        }
        if(curr == null) return;
        dfs(curr.right, target1, target2, path);//assume no dup in tree
        path.remove(path.size() - 1);
        dfs(curr.left, target1, target2, path);
        path.remove(path.size() - 1);
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-1);
        TreeNode n2 = n1.left = new TreeNode(0);
        TreeNode n3 = n2.left = new TreeNode(-2);
        TreeNode n4 = n2.right = new TreeNode(4);
        TreeNode n5 = n3.left = new TreeNode(8);
        LowestCommonAncestorOfABinaryTree236 x = new LowestCommonAncestorOfABinaryTree236();
        x.lowestCommonAncestor(n1, n2, n2);
        
    }
}
