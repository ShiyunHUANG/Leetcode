package easy;

import java.util.ArrayList;
import java.util.List;

public class FlipGame293 {
    List<String> res = new ArrayList<String>();
    /**too slow*/
    public List<String> generatePossibleNextMoves(String s) {
        if(s.length() <= 1) return res;
        int left = 0, right = 1;
        while(right < s.length()) {
            boolean b1 = s.charAt(left) == '-';
            boolean b2 = s.charAt(right) == '-';
            if (!b2) {
                if (!b1) {
                   res.add(s.substring(0, left) + "--" + s.substring(right + 1, s.length())); 
                }   
                left = right;
                right++;
                continue;
            }
            else {//b1 && b2 or b2
                left = right + 1;
                right = left + 1;
            }
        }
        return res;
    }
}
