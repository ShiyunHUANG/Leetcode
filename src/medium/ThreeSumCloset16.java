package medium;

import java.util.Arrays;

public class ThreeSumCloset16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        for(int i = 0; i < len - 2; i++) {
            // System.out.println("-----------");
            //2 sum part
            int p = i + 1, upper = p + 1;//pointer and upper bound
            int sum = nums[i] + nums[p] + nums[upper];
            if(sum >= target) break;
            while(sum < target) {
                sum = nums[i] + nums[p] + nums[upper];
                if(upper + 1 == len || sum >= target) break;//!!!
                upper++;
                // System.out.println("***" + i + " " + p + " " + upper);
            }
            res = res + upper - p;
            if(sum >= target) res--;
            // System.out.println("~~res " + res);
            // res = res + upper - p - 1;
            //lower the upper bound and increase p to see if it will work
            for(p = p + 1; p < upper; p++) {
                sum = nums[i] + nums[p] + nums[upper];
                while(sum >= target && p < upper) {
                    upper--;
                    sum = nums[i] + nums[p] + nums[upper];
                }
                if(p == upper) break;//!!
                // System.out.println(i + " " + p + " " + upper);
                res = res + upper - p;
                // System.out.println("##res " + res);
            }
        }
        return res;
    }
}
