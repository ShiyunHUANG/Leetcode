package easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings105 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        char first [] = s.toCharArray();
        char second [] = t.toCharArray();
        if (first.length != second.length) {
            return false;
        }
        //same length.
        for (int i = 0; i < first.length; i++) {
            if (map.containsKey(first[i]) && second[i] != map.get(first[i])) {
                return false;
            } else {
                map.put(first[i], second[i]);                 
            }
        }
        map.clear();
        for (int i = 0; i < first.length; i++) {
            if (map.containsKey(second[i]) && first[i] != map.get(second[i])) {
                return false;
            } else {
                map.put(second[i], first[i]);                 
            }
        }
        return true;
   }
    public static void main(String[] args) {
    }

}
