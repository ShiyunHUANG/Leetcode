package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestIncreasingSubsequence300 {
  //reason that goes wrong is than for 2, 8, 3, 4, 5 => 2, 3, 4, 5 not 2, 8
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        int res = 0;
        for(int i = 0; i < nums.length; i++) { //i is exclusive
            int insert = Arrays.binarySearch(dp, 0, res, nums[i]);//toIndex is not i, is res
            if(insert < 0) insert = - insert - 1;
            dp[insert] = nums[i];
            if(insert == res) res++;
        }
        return res;
    }
    //WRONG
/*    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //each entry represent a subarray, key is the biggest int, val is the length
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(nums[0], 1);
        int max = nums[0];
        for(int i : nums) {
            if(i <= max) {
                map.putIfAbsent(i, 1);
                continue;
            }
            //if i is bigger than current max in the map, no need to add a new entry
            int maxLen = 0;
            for(Integer k : new HashSet<Integer>(map.keySet())) {
                if(i > k) {
                    if(map.get(k) > maxLen) {
                        maxLen = map.get(k);
                        map.remove(k);
                        map.put(k, maxLen + 1);
                    }
                }
            }
        }
        int res = 0;
        for(Integer i : map.values()) {
            if(i > res) res = i;
        }
        return res;
    }*/
}
