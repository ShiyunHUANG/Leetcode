package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int target) {//k numbers that add up to target number,
        dfs(new ArrayList<Integer>(), 1, 0, k, target);
        return res;
    }
    private void dfs(List<Integer> path, int start, int sum, int k, int target) {
        if(path.size() == k) {
            if (sum == target) {
                res.add(new ArrayList<Integer>(path));                
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(path, i + 1, sum + i, k, target);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {

    }

}
