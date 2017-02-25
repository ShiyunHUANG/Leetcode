package medium;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfABinaryTree366 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root != null) {
            height(root);
        }
        return res;
    }
    private int height(TreeNode node) {
        if(node == null) {
            return -1;
        }
        int h = 1 + Math.max(height(node.left), height(node.right));
        if (res.size() == h) {
            res.add(new ArrayList<Integer>());
        }
        res.get(h).add(node.val);
        node.left = node.right = null;
        return h;
    }
    /*List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> level;
    public List<List<Integer>> findLeaves(TreeNode root) {
        for(int i = 0; i < 3; i++) {
            level = new ArrayList<Integer>();
            dfs(root);
            res.add(level);
        }
        return res;
    }
    private void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        dfs(node.right);
        level.add(node.val);
        System.out.println(node.val);
        
        node.left = node.right = null; //these are field var. erase the child nodes.
//        node = null;//this is a local var! set null here change nothing
    }*/
    public static void main(String[] args) {
        FindLeavesOfABinaryTree366 x = new FindLeavesOfABinaryTree366();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(x.findLeaves(n1));
    }
}
