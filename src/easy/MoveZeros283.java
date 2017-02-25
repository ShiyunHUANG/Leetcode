package easy;

public class MoveZeros283 {
    /*Other's clever method*/
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;        
        //one pointer for an increasing pointer for position.
        int insertPos = 0;
        //loop once, if number not 0, put it in the pointer's position and increase position by 1
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }        
        //in the end fill all slots after pointer 0.
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
    /*My two pointers method*/
    public void moveZeroes(int[] nums) {
        if(nums == null) return;
        int p1 = 0, p2 = 1;
        while (p2 < nums.length) {
            if(nums[p2] == 0) {
                p2++;
                continue;
            }
            if(nums[p1] == 0) {
                int tmp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = tmp;
            }
            p1++;
            if(p2 <= p1) p2 = p1 + 1;// p2++;
        }
    }
}
