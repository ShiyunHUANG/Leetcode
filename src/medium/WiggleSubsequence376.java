package medium;

public class WiggleSubsequence376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int res = 1;
        int i = 1;
        for( ; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] != 0) break;
        }
        if(i == nums.length) return res;
        res++;
        boolean oldCase = (nums[i] - nums[i - 1] > 0);
        int oldNum = nums[i];
        for(i = i + 1; i < nums.length; i++) {
            int tmp = nums[i] - oldNum;
            if(tmp == 0) continue;
            boolean currCase = tmp > 0;
            if(currCase ^ oldCase) res++; //wiggles
            oldNum = nums[i];
            oldCase = currCase;
        }
        return res;
    }
}
