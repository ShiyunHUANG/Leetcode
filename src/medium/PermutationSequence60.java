package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationSequence60 {
    /** Correct method*/
    public String getPermutationCorrect(int n, int k) {
        String res = "";
        //create list with 1 ~ n (9)
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        //create array of factorial
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;//fact[i] is i!
        }
        //loop
        k = k - 1;//!!!
        for (int i = n - 1; i >= 0; i--) {
            // System.out.println("k " + k + " fact " + fact[i] + " i " + i);
            res = res + list.get(k / fact[i]);
            list.remove( k / fact[i]);
            k = k % fact[i];
        }
        return res;
    }
    
    /**my TLE method*/
    String res;
    int count = 0;
    Set<Integer> set = new HashSet<Integer>();
    public String getPermutation(int k, int n) {
        dfs(n, "", k, 1);
        return res;
    }
    private void dfs(int k, String path, int n, int num) {//num is 1 ~ 9
        // System.out.println(count + " " + path);
        if (path.length() == n) {
            count++;
            if(count == k) res = path;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;
            set.add(i);
            dfs(k, path + i, n, i + 1);
            set.remove(i);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
