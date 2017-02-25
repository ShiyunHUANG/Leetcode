package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode89 {
    /*Feb 14 2017*/
    public List<Integer> grayCode2(int n) {
        //dp, symmetric the previous, one half add 0, another add 1
        //in bit manipulation, equals to adding 2^(n-1);
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int m = 1; m <= n; m++) {
            for(int i = res.size() - 1; i >= 0; i--) {
                res.add(res.get(i) + (1 << (m - 1)));//bit manipulation has a low priority, so add ()
            }
        }
        return res;
     }
    /**This is the correct method*/
    public List<Integer> grayCodeCorrect(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);//always start with 0
        for(int i = 0; i < n; i++) {
            int base = 1<<i;
            System.out.println("1<<" + i + " " + base);//1<<0 is 2^0==1
            for(int k = res.size() - 1; k >= 0; k--) {
                System.out.println("k " + res.get(k));
                res.add(base + res.get(k));
            }
        }
        return res;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        //        if(n == 0) return res;
        List<List<Boolean>> list = dfs(n);
        for(List<Boolean> li : list) {
            res.add(binary2Int(li));
        }
        return res;
    }
    private List<List<Boolean>> dfs(int n) {
        int size = (int)Math.pow(2, n);
        List<List<Boolean>> res = new ArrayList<List<Boolean>>(size);
        for(List<Boolean> li : res) {
            li.add(false);
        }
        //terminate condition
        if(n == 0) return res;
        /*        if (n == 1) {
            res.add(Arrays.asList((new Boolean[]{false})));//backlist size is fixed, cannot add to it
            res.add(Arrays.asList((new Boolean[]{true})));
            return res;
        }*/
        //n > 1, recursion
        for (int i = 0; i < (int)Math.pow(2, n - 1); i++) {
            //add symmetrically to the middle
            List<Boolean> firstHalf;
            if(n - 1 == 0) {
                firstHalf = new ArrayList<Boolean>();
            } else {
                firstHalf = dfs(n-1).get(i);
            }
            List<Boolean> secondHalf = new ArrayList<Boolean>(firstHalf);
            firstHalf.add(0, false);
            secondHalf.add(0, true);
            res.add(i, firstHalf);
            res.add(size - 1 - i, secondHalf);
        }
        return res;
    }
    private int binary2Int(List<Boolean> list) {
        int res = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)) res += Math.pow(2, list.size() - i);
        }
        return res;
    }
    public static void main(String[] args) {
        GrayCode89 x = new GrayCode89();
//        System.out.println(x.grayCode(2));
    }
}
