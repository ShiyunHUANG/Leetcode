package medium;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements453 {
    public int minMoves(int[] nums) {
        int steps = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            steps = steps + nums[i] - nums[0];
        }
        return steps;
    }
}
