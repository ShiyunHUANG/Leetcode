package Yahoo;
//easy lock
/*
 * Given a non-empty binary search tree and a target value, find the value in the BST
 *  that is closest to the target. 
 *  Note:
    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.
 * 
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class ClosestBinarySearchTreeValue270 {

    public int closestValue(TreeNode root, double target) {
        //root assume not null
        TreeNode curr = root, closest = root;
        double diff = Math.abs((double)root.val - target);
        while(curr != null) {
            if(target < curr.val && curr.left != null) {
                curr = curr.left;
            } else if (target > curr.val && curr.right != null) {
                curr = curr.right;
            } else break;
            double tmpDiff = Math.abs(target - (double)curr.val);
            if(tmpDiff < diff) {
                closest = curr;
                diff = tmpDiff; //!! remember this
            }
            // else break; //!!!!discard this for corner case
        }
        return closest.val;
    }
}
