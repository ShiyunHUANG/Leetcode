package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
    //Feb 25
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int li = 0; li <= nums.length; li++) { //limit
            dfs(res, li, new ArrayList<Integer>(), nums, 0);
        }
        return res;
    }
    private void dfs(List<List<Integer>> res, int limit, List<Integer> subset, int[] nums, int idx) {
        if(subset.size() == limit) {
            res.add(new ArrayList<Integer>(subset));
            return;
        } 
        if(idx == nums.length) return;
        while(idx < nums.length) {
            subset.add(nums[idx]);
            idx++;
            dfs(res, limit, subset, nums, idx);
            subset.remove(subset.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(nums == null) return res;
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            System.out.println("size " + size);
            for (int j = 0; j < size; j++) {
                res.add(new ArrayList<Integer>(res.get(j)));//MUST NEW ONE!
                System.out.println("copy " + res.get(j));
                res.get(j).add(nums[i]);
                System.out.println("added " + res.get(j));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Subsets78 x = new Subsets78();
        System.out.println(x.subsets(new int[] {1,2,3}));
    }

}
