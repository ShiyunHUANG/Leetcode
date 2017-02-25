package medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        List<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        boolean b = true;//left then right
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i = size - 1; i >= 0; i--) {
                TreeNode curr = q.remove(i);
                tmp.add(curr.val);
                if(b) {
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                } else {
                    if(curr.right != null) q.add(curr.right);
                    if(curr.left != null) q.add(curr.left);
                }
            }
            b = !b;
            res.add(tmp);
        }
        return res;
    }
}
