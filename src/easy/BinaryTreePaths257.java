package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<StringBuilder> res = new ArrayList<StringBuilder>();
        StringBuilder sb = new StringBuilder("");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> trace = new Stack<TreeNode>();
        TreeNode curNode = root;
        while (curNode != null) {
            while(curNode.left!=null) {
                curNode = curNode.left;
                stack.push(curNode);
            }

        }
        while (!trace.isEmpty()) {
            sb.append(trace.pop().val);
            if(!trace.isEmpty())sb.append("->");
        }
        res.add(sb);
        return null;//TODO
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
