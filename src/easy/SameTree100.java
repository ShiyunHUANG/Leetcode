package easy;

import java.util.TreeMap;
import java.util.TreeSet;;

/*
 * Definition for a binary tree node.
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       /* if(p==null&&q==null){
            return true;
        }
        boolean b1=p.val==q.val;*/
        //when only one of them is null, throws a null pointer exception
        boolean b1=false;
        if (p==null&&q==null){
            return true;
        }
        else if (p!=null&&q!=null&&p.val==q.val){
            b1 = true;
        }
        else return false;
        boolean b2;
        if (p.left==null&&q.left==null){
            b2 = true;
        }
        else if (p.left!=null&&q.left!=null&&p.left.val==q.left.val){
            b2 = true;
        }
        else return false;
        boolean b3;
        if (p.right==null&&q.right==null){
            b3 = true;
        }
        else if (p.right!=null&&q.right!=null&&p.right.val==q.right.val){
            b3 = true;
        }
        else return false;
        if(b1&&b2&&b3){
            return (isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
        }
        else return false;
    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(0);
        TreeNode t2=new TreeNode(0);
        TreeNode t3=null;
        t1.left=null;
        t1.right=new TreeNode(1);
        t2.left=null;
        t2.right=new TreeNode(1);
        System.out.println(new SameTree100().isSameTree(t3, t2));
    }

}
