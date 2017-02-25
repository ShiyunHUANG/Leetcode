package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SubsetsII90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//static method. ascending sort.
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> level;
        res.add(new ArrayList());//add an empty set
        int size = 1;//keep increasing, thus no need to be in the loop.
        for (int i = 0; i < nums.length; i++) {
            int begin = 0;//should start from 0 every loop.
            if (i != 0 && nums[i] == nums[i-1]) {
                begin = size;//old size
            }
            size = res.size();//mark down the original size.
            for (int j = begin; j < size; j++) {
                level = new ArrayList<Integer>(res.get(j));//must new here
                level.add(nums[i]);
                res.add(level);
            }
        }
        return res;
    }

    /*if(nums == null) {
            return new ArrayList<List<Integer>>();
        }
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        set.add(new ArrayList<Integer>());

        Set<List<Integer>> newSet;
        for (int i : nums) {
            copy the set to the new set
            System.out.println("set" + set);
            newSet = new HashSet<List<Integer>>();
            System.out.println("empty newSet" + newSet);
            newSet.addAll(set);

            System.out.println("copied newSet" + newSet);

            add the new number in the new set
            for (List<Integer> e : newSet) {
                 e.add(i);
                System.out.println("added newSet " + newSet);
                System.out.println("******* " + set);
            }

            add the element in the new set to the old set
            for (List<Integer> f : newSet) {
                set.add(f);
                System.out.println("**");
            }
            set.add(new ArrayList<Integer>());
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (List<Integer> list : set) {
            res.add(list);
        }
        return res;
    }*/
    public static void main(String[] args) {
        SubsetsII90 x = new SubsetsII90();
        System.out.println(x.subsetsWithDup(new int[]{1,2,8,8}));
    }
}
