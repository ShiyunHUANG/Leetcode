package medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        //preorder curr -> left -> right, inorder left -> curr -> right
        Map<Integer, Integer> in = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return dfs(0, 0, inorder.length - 1, preorder, in);
    }
    private TreeNode dfs(int preIdx, int inStart, int inEnd, int[] pre, Map<Integer, Integer> in) {
        if(preIdx > pre.length || inStart > inEnd) return null;//!!!
        TreeNode res = new TreeNode(pre[preIdx]);
        int inIdx = in.get(pre[preIdx]);
        int leftTreeLen = inIdx - inStart;
        res.left = dfs(preIdx + 1, inStart, inIdx - 1, pre, in);
        res.right = dfs(preIdx + leftTreeLen + 1, inIdx + 1, inEnd, pre, in);
        return res;
    }
}
