package medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int[] nums, int idx, List<Integer> path) {
        List<Integer> another = new ArrayList<Integer>(path);
        if (path.size() == nums.length) {
            res.add(path);
            return;
        }
        for (int curr = 0; curr < nums.length ; curr++) {
            if (path.contains(nums[curr])) continue;
            another = new ArrayList<Integer>(path);
            another.add(nums[curr]);
            dfs(nums, idx + 1, another);
        }
        /*if (another.size() == nums.length) res.add(another);
        return;*/ 
        //this one is wrong, will double the results.
        //Think of [1, 2, 3], when adding 3, it goes into dfs(nums, 4, another);
        //4 will not go into the for loop, but add another to result.
        //Now returning to 3, add another to result again.
        //But if adding to res is before the for loop, when 4, path is added and return 
        //to 3. 3 reaches the end and return to 2, then skip the "adding to res part"
        //and enter the for loop for 2.
        //But when 3, it reaches the bottom
    }
}
