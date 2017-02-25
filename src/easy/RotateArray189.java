package easy;
/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7]
 *  is rotated to [5,6,7,1,2,3,4]. 
 *  Note:
 *  Try to come up at least 3 different ways to solve this problem. 
 * @author Shiyun Huang
 *
 */
public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        if (k % nums.length == 0) return;
        if (k > nums.length) {
            k = k % nums.length;
        }
        int temp[] = new int[nums.length - k];
        //store nums.length - k.
        for (int i = 0; i < nums.length - k; i++) {
            temp[i] = nums[i];
        }
        for (int i = nums.length - k; i < nums.length; i++) {
            nums[i + k - nums.length] = nums[i];
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = temp [i - k];
        }
    }
    public static void main(String[] args) {

    }

}
