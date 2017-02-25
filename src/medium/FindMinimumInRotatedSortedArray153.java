package medium;

public class FindMinimumInRotatedSortedArray153 {
    public int findMin(int[] nums) {
        int a = 0; //left
        int b = nums.length - 1; //right
        int mid;
        while(a < b - 1) {
            mid = a + (b - a) / 2;
            // System.out.println("a " + a + " b " + b + " mid " + mid);
            if(nums[b] < nums[a]) { //rotated
                if(nums[mid] > nums[a]) { // the left part is increasing
                    a = mid + 1;
                } else {
                    b = mid;
                }
            } else return nums[a]; //not rotated
        }
        return Math.min(nums[a], nums[b]);
    }
}
