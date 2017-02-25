package medium;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations254 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int n, int startFactor, List<Integer> factors) {
        //termination condition
        if(n == 1) {
            if (factors.size() > 1) {
                res.add(new ArrayList<Integer>(factors));//!!! must new
            }
            return;
        }
        //recurrsion
        for(int f = startFactor; f <= n; f++) {
            if(n % f == 0) {
                factors.add(f);
                dfs(n / f, f, factors);
                factors.remove(factors.size() - 1);
            }
        }
    }

    /**
     * Others good answer, the main point is to start a new loop (to find factors) at 
     * a number than is >= prior factors
     */
    /*
public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(result, new ArrayList<Integer>(), n, 2);
    return result;
}

public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
    System.out.println("in dfs, start from " + start);
    if (n <= 1) {
        if (item.size() > 1) {
            result.add(new ArrayList<Integer>(item));
            System.out.println("res add " + item);
        }
        return;
    }

    for (int i = start; i <= n; ++i) {
        if (n % i == 0) {
            item.add(i);
            System.out.println("add " + i + " now " + item);
            helper(result, item, n/i, i);
            item.remove(item.size()-1);
            System.out.println("remove i: " + i + " now " + item + " n is " + n);
        }
    }
}
     */


    /**
     * my original though, find the smallest factors then combination, but have duplicate
     */
    /*List<List<Integer>> solution = new ArrayList<List<Integer>>();
    public List<List<Integer>> getFactors(int n) {
        List<Integer> small = smallestFactors(n);
        dfs(small, 0, 1, new ArrayList<Integer>());
        return solution;

    }
    private List<Integer> smallestFactors(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n < 4) return res;
        for (int i = 2; i < n && n > 3; ) {
            if(n % i == 0) {
                res.add(i);
                n = n / i;
                i = 2;
            } else {
                i++;
            }
        }
        res.add(n);
        return res;
    }
    private void dfs(List<Integer> list, int pos, int multi, List<Integer> factors){
        int ori = factors.size();
        //terminate condition
        if (pos == list.size()) {
            solution.add(factors);
            return;
        } 
        //keep it
        if(multi > 1) {
            factors.add(multi);
        }
        factors.add(list.get(pos));
        dfs(list, pos + 1, 1, factors);    
        //multiple it
        dfs(list, pos + 1, multi * list.get(pos), factors);
        factors.subList(0, ori);

    }*/
}
