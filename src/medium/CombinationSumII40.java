package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
       dfs(new ArrayList<Integer>(), candidates, target, 0, 0);
       return res; 
    }
    private void dfs(List<Integer> path, int[] cand, int target, int idx, int sum) {
        if(sum == target) {
            res.add(path);
            return;
        }
        if (sum > target) {
            return;
        }
        for (int curr = idx; sum < target && curr < cand.length; curr++) {
            if (curr > idx && cand[curr] == cand[curr - 1]) continue;//Hint!!!!!!!!!!!
            List<Integer> another = new ArrayList<Integer>(path);//MUST NEW
            another.add(cand[curr]);
            dfs(another, cand, target, curr + 1, sum + cand[curr]);
            
        }
        
    }
}
