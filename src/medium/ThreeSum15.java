package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    //remove dup!!!
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return res;
        Arrays.sort(nums);
        dfs(0, nums, 0, new ArrayList<Integer>(), 0);
        return res;
    }
    private void dfs(int start, int[] nums, int sum, List<Integer> path, int target) {
        // System.out.println("start idx " + start + " path " + path);
        if(path.size() == 3) {
            if(sum == target) res.add(new ArrayList<Integer>(path));
            return;
        }
        Integer lastOne = null;//remove dup
        for(int i = start; i < nums.length; i++) {
            if(lastOne != null && lastOne == nums[i]) continue; //remove dup
            path.add(nums[i]);
            dfs(i + 1, nums, sum + nums[i], path, target);
            lastOne = path.get(path.size() - 1);
            path.remove(path.size() - 1);
        }
    }
}
