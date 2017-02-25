package medium;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII80 {
    /**Simple solution*/
    public int removeDuplicates3(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) {
                nums[i] = n;
                i++;                
            }
        }
        return i;
    }

    /**General methods for keeping k dup*/
    int removeDuplicates2(int nums[], int k) {
        int len = nums.length;
        if (len <= k) return len;
        int res = 1, ct = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i-1]) {
                ct = 1;
                nums[res] = nums[i];
                res++;
            }
            else { //duplicate
                if (ct < k) {
                    nums[res] = nums[i];
                    ct++;
                    res++;
                }
            }
            for(int a : nums) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        return res;
    }
    /**My Stupid method*/
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return 2;
        int res = nums.length, ct = 1, p = nums.length - 1, curr = nums[p]; 
        //res is totoal dup, ct is count for each number, p is pointer
        //use curr to mark the first appearence of the number, avoid comparing next one because of swapping
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] != curr) {
                ct = 1;
                curr = nums[i];
            }
            else { //duplicate
                if(ct < 2) ct++;
                else {
                    res--;
                    int tmp = nums[p];
                    nums[p] = nums[i];
                    nums[i] = tmp;
                    p--;
                }
            }
        }
        Arrays.sort(nums, 0, res);
        return res;
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII80 x = new RemoveDuplicatesFromSortedArrayII80();
        x.removeDuplicates2(new int[]{0,0,0,1,1,1,5,5,5,7,9}, 2);
    }
}
