package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    private void dfs(List<Integer> path, int k, int n, int start) {
        if(path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start; i <= n; i++) {
            path.add(i);
            dfs(path, k, n, i + 1);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {

    }

}
