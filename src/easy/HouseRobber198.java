package easy;

public class HouseRobber198 {
    public int rob(int[] nums) {
        int res = 0;
        int length = nums.length;
        if (length == 0) {
            return res;
        } else if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (length == 3) {
            return Math.max(nums[1], nums[0] + nums[2]);
        }
        int val[] = new int[length];//maximum val, start from 0 to corresponding indeces.
        val[0] = nums[0];
        val[1] = Math.max(nums[0], nums[1]);
        val[2] = Math.max(nums[1], nums[0] + nums[2]);
        for (int i = 3; i < length; i++) {
            val[i] = nums[i] + Math.max(val[i-2], val[i-3]);
            // System.out.println("val[" + i + "] = " + val[i]);
        }
        return Math.max(val[length - 1], val[length - 2]);
    }
}
