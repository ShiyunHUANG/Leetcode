package easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString438 {
    /*
    hash[s.charAt(right) - 'a']--;
    count--;
    These two are used to track which char is used.
    To distinguish between "char NOT in anagram" and "char IN anagram but used up"
    We need to do the above operations everytime we use a s char
    So that in the end, "IN" will be >= 0 while "NOT in" is < 0 (in the slider)
    In short, count is the only thing changed when two char matches
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s.length() < p.length()) return res;
        //hash for 26 letters
        int[] hash = new int[26];//Integer[] can't initialize itself
        for (char ch : p.toCharArray()) {
            hash[ch - 'a']++;//others are 0
        }
        //pointers for s(input) and count for p(anagram)
        int left = 0, right = 0, count = p.length();
        for (; right < s.length(); right++) {
            System.out.println("left " + left + " right " + right + " count " + count);
            //if the hash has the current char at right pointer
            if(hash[s.charAt(right) - 'a'] >= 1) {
                count--;//ERASE LATER
            }
            hash[s.charAt(right) - 'a']--;//OUTSIDE THE ABOVE IF(), ERASE LATER
            if(count == 0) { //count is 0, slider has all legal chars
                res.add(left);
            }
            if(right + 1 - left == p.length()) { //slider is full
                if(hash[s.charAt(left) - 'a'] >= 0) {
                    count++;//ERASING
                }
                hash[s.charAt(left) - 'a']++;//ERASING
                left++;
            }
        }
        return res;
    }
    /**
     * TLE Method
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s.length() < p.length()) return res;
        Integer[] all = new Integer[26];
        for (int i = 0; i < 26; i++) {
            all[i] = 0;
        }
        for (char ch : p.toCharArray()) {
            all[ch - 'a']++;
        }
        List<Integer[]> list = new ArrayList<Integer[]>();
        int ch = 0;
        char[] chArr = s.toCharArray();
        for( ; list.size() < p.length(); ch++) {
            list.add(all.clone());
            for(Integer[] arr : list) {
                arr[chArr[ch] - 'a']--;                    
            }
        }
        if (match(list.get(0))) res.add(ch - p.length());
        for( ; ch < s.length(); ch++) {
            list.remove(0);
            list.add(all.clone());
            for(Integer[] arr : list) {
                arr[chArr[ch] - 'a']--;                    
            }
            if (match(list.get(0))) res.add(ch - p.length() + 1);
        }
        return res;
    }
    private boolean match(Integer[] arr) {
        for(int i : arr) {
            if (i != 0) return false;
        }
        return true;
    }
}
