package medium;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray384 {
    int[] arr, ori;
    Random r;
    public ShuffleAnArray384(int[] nums) {
        arr = nums;
        ori = Arrays.copyOf(nums, nums.length); //!!!!hard copy
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        arr = ori;
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = arr.length;
        int res[] = new int[len];
        for(int i = 0; i < len; i++) {
            int idx = r.nextInt(len - i);
            res[i] = arr[idx];
            //swap
            int tmp = arr[idx];
            arr[idx] = arr[len - 1 - i];
            arr[len - 1 - i] = tmp;
        }
        return res;
    }
    public static void main (String[] args) {
        int[] test = new int [] {1,2,3,4,5};
        ShuffleAnArray384 x = new ShuffleAnArray384(test);
        for(int a : x.shuffle()) System.out.print(a + " ");
        System.out.println();
        for(int a : x.reset()) System.out.print(a + " ");
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */