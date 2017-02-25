package medium;

import java.util.Arrays;

public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        int[] plus = new int[nums.length];
        int[] minus = new int[nums.length];
        Arrays.fill(plus, 0);
        Arrays.fill(minus, 0);
        if(nums[0] > 0) plus[0] = nums[0];
        if(nums[0] < 0) minus[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            boolean prevPlus = plus[i - 1] > 0, prevMinus = minus[i - 1] < 0, positive = nums[i] > 0;
            if(!prevPlus && !prevMinus) {
                if(positive) plus[i] = nums[i];
                else minus[i] = nums[i];
            }
            int multiPlus = nums[i] * plus[i - 1], multiMinus = nums[i] * minus[i - 1];
            if(positive) {
                if(prevPlus) plus[i] = multiPlus > nums[i] ? multiPlus : nums[i];
                else plus[i] = nums[i];
                minus[i] = multiMinus;
            } else { //negative
                if(prevPlus) minus[i] = multiPlus < nums[i] ? multiPlus : nums[i];//notice is <
                else minus[i] = nums[i];
                plus[i] = multiMinus;
            }
            max = Math.max(max, plus[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
