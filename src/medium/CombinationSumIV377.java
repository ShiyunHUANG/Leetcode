package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV377 {
    /**others DP Solution using map*/
    Map<Integer, Integer> map = new HashMap<>();
    int level = 0;
    public int combinationSum4B(int[] nums, int target, int level) {
        System.out.println("**********" + level + "***********" + target + "\n");
        int count = 0;
        if (nums == null || nums.length ==0 || target < 0 ) return 0;
        if ( target == 0 ) {
            System.out.println("level " + level + "++++++");
            return 1;
        }
        if (map.containsKey(target)) {
            System.out.println("map get " + target + ", " + map.get(target));
            return map.get(target);
        }
        for (int num : nums) { //only recur when target is bigger than sum
            System.out.println(num);
            count = count + combinationSum4B(nums, target-num, level + 1);
        }
        System.out.println("target " + target + " count " + count);
        map.put(target, count);
        return count;
    }
    /**My TLE backtracking solution*/
    private int res = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(0, nums, target);
        return res;
    }
    private void dfs(int sum, int[] nums, int target) {
        for(int n : nums) {
            int tmp = sum + n;
            if(tmp >= target) {
                if(tmp == target) res++;
                break;
            } else dfs(tmp, nums, target);
        }
    }
    /**My DP solution*/
    int[] dp;
    public int combinationSum4C(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dfs(nums, target);
        return dp[target];
    }
    //make sure every depth only iterate once(next depth is irrelevant to this depth)
    private int dfs(int[] nums, int target) {
        if(target < 0) return 0;
        if(dp[target] != -1) return dp[target];
        int count = 0;
        for(int n : nums) {
            count = count + dfs(nums, target - n);
        }
        dp[target] = count;
        return count;
    }
    public static void main(String[] args) {
        int[] test = new int[]{1};
        CombinationSumIV377 x = new CombinationSumIV377();
        System.out.println("res " + x.combinationSum4B(test, 0, 0));
    }
}
