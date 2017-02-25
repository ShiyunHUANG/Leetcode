package medium;

import java.util.Random;

public class RandomPickIndex98 {
    int[] nums;
    public RandomPickIndex98(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int len = nums.length, res = -1;
        Random r = new Random();
        int count = 0;
        for(int i = 0 ; i < len; i++) {
            if(nums[i] == target) {
                if(r.nextInt(count + 1) == count) {
                    res = i;
                }
                count++; //careful, not in the upper loop
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }

}
