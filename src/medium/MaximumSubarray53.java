package medium;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int res = Integer.MIN_VALUE, tmp = Integer.MIN_VALUE;//res is current maximum
        boolean b = true;//start fresh
        for(int i = 0; i < nums.length; i++) {     
            res = res > tmp ? res : tmp; //save old max
            if(nums[i] >= 0) { //positive num must add
                if(tmp < 0 || b) {
                    tmp = nums[i];
                }
                else tmp = tmp + nums[i];
                System.out.println("+ nums[i] " + nums[i] + " tmp " + tmp + " b " + b );
                b = false;
                
            }
            else { //add a negative num
                System.out.println("- nums[i] " + nums[i] + " tmp " + tmp + " b " + b );
                if(b) {
                    if(nums[i] > res) tmp = nums[i];
                }
                else if(nums[i] > tmp) {//[-8 -> -2]
                    tmp = nums[i];
                    b = true;
                }
                else {
                    int sum = tmp + nums[i];
                    if(sum > 0) tmp = sum;//[6 -> -2]
                    else b = true; //[6 -> -8]
                }
            }
        }
        return res = res > tmp ? res : tmp;
    }
    public static void main(String[] args) {
        MaximumSubarray53 x = new MaximumSubarray53();
        System.out.println("res " + x.maxSubArray(new int[]{-2,-1,5, -2,4,8,-5,-1,-9,9,-8,9,-2,3}));

    }

}
