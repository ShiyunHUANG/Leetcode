package AmazonOA;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *Given a string which consists of lowercase or uppercase letters, find the length 
 * of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.
Assume the length of given string will not exceed 1010.
Example
Given s = "abccccdd" return 7
One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class _LongestPalindrome {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        if(s == null) return 0;
        // int len = s.length(); not relevant
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : s.toCharArray()) {
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int res = 0;
        boolean hasOdd = false;
        for(int i : map.values()) {
            if(i % 2 == 0) res += i;
            else {
                hasOdd = true;
                res += i - 1;
            }
        }
        if(hasOdd) return res + 1;
        else return res;
    }
}
