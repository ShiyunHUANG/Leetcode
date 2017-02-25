package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets78 {
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
