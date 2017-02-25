package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIII437 {
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root, new ArrayList<Integer>(), sum);
        return res;
    }
    private void dfs(TreeNode node, List<Integer> sums, int target) {
        if(node == null) return;
        sums.add(0);
        /*for(int s : sums) { //does not change the value, unlike array
            s = s + node.val;
            if (s == target) res++;
        }*/
        for(int s = 0; s < sums.size(); s++) {
            sums.set(s, sums.get(s) + node.val);
            if (sums.get(s) == target) res++;
        }
        // System.out.println(sums);
        dfs(node.left, sums, target);
        dfs(node.right, sums, target);
        
        sums.remove(sums.size() - 1);
        for(int s = 0; s < sums.size(); s++) {
            sums.set(s, sums.get(s) - node.val);
        }
    }
    /**A better solution using Hashmap*/
    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //Default sum = 0 has one count
        return backtrack(root, 0, sum, map); 
    }
    //BackTrack one pass
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root == null)
            return 0;
        sum += root.val;
        // System.out.println("root " + root.val + " sum " + sum + " s - t " + (sum - target));
        int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target, sum - map = target
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
        return res;
    }
    public static void main (String args[]) {
        
    }
}
