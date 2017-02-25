package medium;
/**
 * Treeset
 * @author Shiyun Huang
 *
 */

/*This method out of time limit*/
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1 || k == 0) {
            return false;
        }
        //k is distance
        for (int i = 0; i < nums.length; i++) {
            // System.out.println("length " + nums.length + " i is " + i);
            // System.out.println(nums[i+1] + " , " + nums[i]);
            for (int j = 1; i + j < nums.length && j <= k; j++) {
                long num2 = new Long(nums[i + j]);
                long num1 = new Long(nums[i]);
                long dif = Math.abs(num2 - num1);
                if ( dif <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
