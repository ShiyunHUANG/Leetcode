package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);//not necessary
        dfs(0, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }
    private void dfs(int sum, List<Integer> path, int[] cand, int target, int idx) {
        if (sum == target) {
            res.add(path);
            return;
        }
        if (sum > target) {
            return;
        }
        while (sum < target && idx < cand.length) {
           List<Integer> another = new ArrayList<Integer>(path);
           another.add(cand[idx]);
           dfs(sum + cand[idx], another , cand, target, idx); 
           idx++;
        }
    }
    public static void main(String[] args) {

    }

}
