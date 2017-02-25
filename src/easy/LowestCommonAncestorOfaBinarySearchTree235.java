package easy;

public class LowestCommonAncestorOfaBinarySearchTree235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        if((p.val - ancestor.val) * (q.val - ancestor.val) <= 0){
            return ancestor;
        }
        else if (p.val < root.val){
           return lowestCommonAncestor(root.left, p, q);
        }
        else return lowestCommonAncestor(root.right, p, q);
        
        /**
         * Out of time limit.
         */
/*        
         * declare p and q's ancestors.
         
        TreeNode ancestor = root;
        while ((p.val - ancestor.val) * (q.val - ancestor.val) > 0){
            
             * p, q are on the same side of the root
             
            if (p.val < root.val){
                ancestor = root.left;
            }
            else ancestor = root.right;
        }
        
         * p,q are on each side of the root
         
            return ancestor;        */
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
