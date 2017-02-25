package easy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it 
 * and return it's index. If it doesn't exist, return -1. 
 * Examples: 
 
s = "leetcode"
return 0.
s = "loveleetcode",
return 2.

 * Note: You may assume the string contain only lowercase letters. 
 *
 */
public class FirstUniqueCharacterInString389 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }
            else map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }
        for(int j=0;j<s.length();j++){
            if(map.get(s.charAt(j))==1){
                return j;
            }
        }
        return -1;
    }
    
    /**
     * Other Solution 1: Using array
     */
    
    /*
     *  public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

     */
    
    /**
     * Other Solution 2: Using a string method .lastIndexOf()
     */
    
    /*
     * public static int firstUniqChar(String s) {
        
        char[] a = s.toCharArray();
        
        for(int i=0; i<a.length;i++){
            if(s.indexOf(a[i])==s.lastIndexOf(a[i])){return i;}
        }
        return -1;
    }
     */
    
    public static void main(String[] args) {
        int x=new FirstUniqueCharacterInString389().firstUniqChar("bbcdebcdea");
        System.out.println(x);
    }

}
