package easy;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ClosestBinarySearchTreeValue270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        TreeNode curr = root;
        int floor = Integer.MIN_VALUE, ceiling = Integer.MAX_VALUE;
        while(curr != null) {
            if (target > curr.val) {
                floor = curr.val;
                curr = curr.right;
            } else if (target < curr.val) {
                ceiling = curr.val;
                curr = curr.left;
            } else {
                return curr.val;
            }
        }
        if (ceiling == Integer.MAX_VALUE && floor == Integer.MIN_VALUE) {
            return root.val;
        } else if (ceiling == Integer.MAX_VALUE) {
            return floor;
        } else if (floor == Integer.MIN_VALUE) {
            return ceiling;
        }
        int res = (target - floor >= ceiling - target)? ceiling : floor;
        return res;
    }
}
