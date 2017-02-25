package easy;

import java.util.ArrayList;
import java.util.List;

public class FlipGameII294 {
    public boolean canWin2(String s) {
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
               if(!canWin2(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()))) return true;
            }
        }
        return false;
    }
    /**the opponent is not using the best strategy this way*/
    List<Integer> count = new ArrayList<Integer>();
    public boolean canWin(String s) {
        dfs(s, 0);
        System.out.println(count);
        for(int ct : count) {
            if(ct % 2 == 1) return true;
        }
        return false;
    }
    private void dfs(String s, int ct) {
        boolean canFlip = false;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
               dfs(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()), ct + 1);
               canFlip = true;
            }
        }
        //can not flip anymore
        if(!canFlip) count.add(ct);
    } 
}
