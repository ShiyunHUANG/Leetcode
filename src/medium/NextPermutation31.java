package medium;

import java.util.Arrays;

public class NextPermutation31 {
    /*Find the last increasing number, and select the min number
    that is bigger than num[p] and swap, sort the latter part*/
    public void nextPermutation(int[] nums) {
        int p = -1; //the number before the last increasing number
        int min = -1; //min number than is bigger than p if all num after p is descending
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] > nums[i]) { //increasing
                p = i;
                min = p + 1;
            } else if(p != -1){ //decreasing (at least the second time)
                if(nums[i + 1] > nums[p]) min = nums[min] > nums[i + 1] ? i + 1 : min;
            }
        }
        if (p != -1) { //eliminate all decrease case
            int tmp = nums[p];
            nums[p] = nums[min];
            nums[min] = tmp;            
        }
        Arrays.sort(nums, p + 1, nums.length);
    }
}
