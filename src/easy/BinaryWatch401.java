package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch401 {
    List<String> res =  new ArrayList<String>();
    public List<String> readBinaryWatch(int num) {
        int hrs[] = {1, 2, 4, 8};
        int mins[] = {1, 2, 4, 8, 16, 32};
        for (int i = 0; i <= num; i++) {
            List<Integer> legalHrs = dfs(hrs, 0, i, 0, 11, new ArrayList<Integer>());
            List<Integer> legalMins = dfs(mins, 0, num - i, 0, 59, new ArrayList<Integer>());  
            for(int x : legalHrs) {
                String time = x + ":";
                for(int y : legalMins) {
                    String time2 = time;
                    if (y < 10) time2 = time2 + "0";
                    time2 = time2 + y;
                    res.add(time2);
                }
            }
        }
        return res;
    }
    //start idx of search in arr, n is number of light on, sum <= limit
    private List<Integer> dfs(int[] arr, int start, int n, int sum, int limit, List<Integer> all) {
        // System.out.println("start " + start + " sum " + sum + " n " + n + " limit " + limit);
        //terminate condition
        if(n <= 0) {
            if(sum <= limit) all.add(sum);//0 is also added
            return all;
        }
        //dfs
        for(int i = start; i < arr.length; i++) {
            dfs(arr, i + 1, n - 1, sum + arr[i], limit, all);//notice not n-- is n - 1 (backtracking not change original)
        }
        return all;//?
    }
}
