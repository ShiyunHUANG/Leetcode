package easy;

import java.util.Arrays;

public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int pointer1 = 0;
        int pointer2 = nums.length - 1;
        int res = nums.length;
        //empty input.
        if (res == 0) return res;
        Arrays.sort(nums);
        //remove elements.
        while (pointer1 < nums.length) {
            if (nums[pointer1] != val) {
                pointer1++;
            } else if (nums[pointer1] == nums[pointer2]){//pointer1 == val
                return pointer1;                
            } else {//pointer2 != to val.
                nums[pointer1] = nums[pointer2];
                pointer2--;
                res--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
