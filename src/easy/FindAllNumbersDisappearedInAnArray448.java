package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray448 {
    /**Others negative markers method*/
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if(nums[Math.abs(index) - 1] > 0) { //negate if not already
                nums[Math.abs(index) - 1]= - nums[Math.abs(index) - 1];
            }
        }
        for(int j = 1; j <= nums.length; j++) {
            if (nums[j - 1] > 0){
                result.add(j);
            }
        }
        return result;
    }
    /**My method*/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return list;
        Arrays.sort(nums);
        for(int d = 1; d < nums[0]; d++) {
            list.add(d);
        }
        for(int i = 1; i < nums.length; i++) {
            int dif = nums[i] - nums[i - 1];
            if(dif > 1) {
                for(int d = 1; d < dif; d++) list.add(d + nums[i - 1]);
            }
        }
        for(int d = nums[nums.length - 1] + 1; d <= nums.length; d++) list.add(d);
        return list;
    }
}
