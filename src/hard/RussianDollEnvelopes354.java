package hard;

import java.util.Arrays;

public class RussianDollEnvelopes354 {
  //since width is sorted, find the longest subarray from height
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null|| envelopes.length == 0 || envelopes[0] == null) return 0;
        //sort width ascendingly and sort depth descendingly
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 0);//necessary?
        int res = 0;
        for(int[] e : envelopes) {
            int insert = Arrays.binarySearch(dp, 0, res, e[1]);
            if(insert < 0) {
                insert = - insert - 1;
            }
            dp[insert] = e[1];
            if (insert == res) res++;
        }
        return res;
    }
}
