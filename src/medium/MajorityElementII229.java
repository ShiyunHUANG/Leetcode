package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            int count = 1;
            while(i < nums.length && nums[i] == nums[i - 1]) {
                count++;
                i++;
            } 
            if(count > nums.length / 3) {
                res.add(nums[i - 1]);
                if(nums.length == 2 && count == 1) res.add(nums[i]);
                continue;
            } else {
                count = 1;
            }
        }
        return res;
    }
}
