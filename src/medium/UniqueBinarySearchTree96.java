package medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree96 {
    //1 => 1, 2 => 2， 3=2+1+2
    public int numTrees2(int n) {
        if(n <= 2) return n;
        //m >= 3
        int[] dp = new int[n + 1]; //idx match n exactly
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            int tmp = 0;
            for(int j = 0; j < i; j++) {
                tmp = tmp + dp[j] * dp[i - j - 1];
            }
            dp[i] = tmp;
        }
        return dp[n];
    }
    
    
    
    public int numTrees(int n) {
        //a list recording the values numTrees givin n.
        List<Integer> list = new ArrayList<Integer>();//can use array here since length is known
        list.add(1); //n = 0 has 1 tree
        list.add(1); //n = 1 has 1 tree
        int res = 1;
        for (int i = 2; i < n + 1; i++) {
            res = 0;
            for (int j = 1; j <= i / 2; j++) {
                res += 2 * (list.get(j - 1) * list.get(i - j));
            }
            if (i % 2 == 1) {
                res += list.get(i / 2) * list.get(i / 2);
            }
            list.add(res);
            // System.out.println(list);
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
