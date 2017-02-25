package medium;

import java.util.Arrays;

//a little stupid with duplicate codes
public class WiggleSort280 {
    int p1, p2, temp;//pointers
    boolean three;//for even length, after divide by 2 is even or odd is different
    private void wiggleSortEven(int[] nums, int p1, int p2, boolean three) {
        // boolean condition;
        if (three) {
            while(p1 < p2 - 1) {
            temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1 = p1 + 2;
            p2 = p2 - 2;
            }
            // condition = (p1 < p2 - 1);
        } else {
            // condition = (p1 < p2);
            while(p1 < p2) {
            temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1 = p1 + 2;
            p2 = p2 - 2;
            }
        }
        
    }
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length <= 2) return;
        if(nums.length % 2 == 0) {
            if((nums.length / 2) % 2 == 0) {
                wiggleSortEven(nums, 1, nums.length - 2, false);                            
            } else {
                wiggleSortEven(nums, 1, nums.length - 2, true);            
            }
        } else {
            //odd can be seen as removing the last num, and become even
            //first switch the last 2
            temp = nums[nums.length - 1];
            nums[nums.length - 1] = nums[nums.length - 2];
            nums[nums.length - 2] = temp;
            //now ignore the last one see as if it is even
            // System.out.println(((nums.length - 1)/ 2) % 2 == 0);
            if(((nums.length - 1)/ 2) % 2 == 0) {
                wiggleSortEven(nums, 1, nums.length - 3, false);                            
            } else {
                wiggleSortEven(nums, 1, nums.length - 3, true);            
            }
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
