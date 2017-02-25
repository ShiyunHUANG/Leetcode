package easy;

public class SumofLeftLeaves404 {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode node = root;
        dfs(root);
        System.out.println("res = " + res);
        return res;
    }
    private TreeNode dfs(TreeNode node) {
        if(node == null) {
            return null;
        }
        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);
        System.out.println("node: " + node.val + " left: " + left + " right: " + right);
        //here, it is a leaf
        if (left != null && left.left == null && left.right == null) {
            res = res + left.val;  
            System.out.println(left.val +"****" + res);
        }
        System.out.println("mmm " + res);
        return node;
    }
    public static void main(String[] args) {
           TreeNode n1 = new TreeNode(1);
           TreeNode n2 = n1.left = new TreeNode(2);
           TreeNode n3 = n1.right = new TreeNode(3);
           TreeNode n4 = n2.left = new TreeNode(4);
           TreeNode n5 = n2.right = new TreeNode(5);
           TreeNode n6 = n3.left = new TreeNode(6);
           SumofLeftLeaves404 x = new SumofLeftLeaves404();
           x.sumOfLeftLeaves(n1);
           
    }

}
