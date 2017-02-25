package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        //only one odd can keep all, others must minus one
        int countOdd = 0;
        int res = 0;
        for(int i : map.values()) {
            if(i % 2 == 1) {
                countOdd++;
                res = res + i - 1;
            }
            else res = res + i;
        }
        //since minus one for all odd above, add one back if there is odd num
        if(countOdd >= 1) res = res + 1;
        return res;
    }
}
