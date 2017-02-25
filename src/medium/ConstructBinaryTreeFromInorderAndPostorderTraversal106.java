package medium;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
  //inorder left -> curr -> right, postorder left -> right -> curr
    Map<Integer, Integer> in = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(len == 0) return null;
        for(int i = 0; i < len; i++) {
            in.put(inorder[i], i);
        }
        return dfs(postorder, len - 1, 0, len - 1, in);
    }
    private TreeNode dfs(int[] post, int postIdx, int inStart, int inEnd, Map<Integer, Integer> in) {
        if(postIdx < 0 || inStart > inEnd) return null;
        int inIdx = in.get(post[postIdx]);
        int rightTreeLen = inEnd - inIdx;
        TreeNode root = new TreeNode(post[postIdx]);
        // System.out.println(post[postIdx] + " inStart " + inStart + " inEnd " + inEnd);
        root.left = dfs(post, postIdx - rightTreeLen - 1, inStart, inIdx - 1, in);
        root.right = dfs(post, postIdx - 1, inIdx + 1, inEnd, in);
        return root;
    }
}
