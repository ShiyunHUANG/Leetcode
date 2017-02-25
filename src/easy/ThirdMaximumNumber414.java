package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdMaximumNumber414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        List<Integer> max = new ArrayList<Integer>();
        int tmp = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0 && max.size() < 2; i--) {
            if (nums[i] < tmp) {
                max.add(nums[i]);
                tmp = nums[i];
            }
            // System.out.println(max.size() + "," + i);
        }
        if (max.size() < 2) {
            return nums[nums.length - 1];
        } else {
            return max.get(1);
        }
/*        int max = nums[nums.length - 1];
        if (nums.length <= 2) {
            return max;
        } else {
            for (int i = nums.length - 2, count = 0; count < 3 ; i--) {
                if (nums[i] < max && i >= 0) {
                    count++;
                    max = nums[i];
                }
                
            }
        }
        return max;*/
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
