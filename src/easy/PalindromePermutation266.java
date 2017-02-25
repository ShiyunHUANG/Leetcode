package easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation266 {
    public boolean canPermutePalindrome(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char a : arr) {
            if(!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                if (map.get(a) == 1) {
                    map.put(a, 0);                    
                } else {
                    map.put(a, 1);
                }

            }
        }
        ArrayList<Integer> valueList = new ArrayList<Integer>(map.values()); //!!!
        if(s.length() % 2 == 0) { //even
            for(int i : valueList) {
                if(i == 1) return false;
            }            
        } else { //odd
            int count = 0;
            for(int i : valueList) {
                if(i == 1) {
                    count++;
                    if (count > 1) return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
