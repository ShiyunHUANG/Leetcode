package medium;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers386 {
    /**
     * Others iterative method
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int i = 1;
        for(int ct = 1; ct <= n; ct++) {
            res.add(i);
            if(i * 10 <= n) {
                i = i * 10;
            } else if (i % 10 != 9 && i + 1 <= n) { //don't foret <=
                i++;
            } else {
                while((i / 10) % 10 == 9) i = i / 10; //!!!!
                i = i / 10 + 1; //not just i++; e.g. 12 with target of 12 goes here 
            }
        }
        return res;
    }
    /**DFS solution*/
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
          dfs(i, n, res); 
        }
        return res;
    }
    
    public void dfs(int cur, int n, List<Integer> res) {
        if(cur > n)
            return;
        else{
            res.add(cur);
            for(int i = 0; i <= 9; i++) {
                int tmp = 10 * cur;
                if(tmp + i > n) return;
                else dfs(tmp + i, n, res);
            }
        }
    }
}
