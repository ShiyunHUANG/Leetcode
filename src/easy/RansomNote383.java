package easy;

import java.util.HashMap;
import java.util.Map;

/*
 * I took the questino wrongly. the first string doesn't have to be in the same order as the
 * next one, just make sure the second one has all the char in the first string
 */
        
/**
 * Given an arbitrary ransom note string and another string containing 
 * letters from all the magazines, write a function that will return true 
 * if the ransom note can be constructed from the magazines ; otherwise, 
 * it will return false. Each letter in the magazine string can only be 
 * used once in your ransom note. 
 * Note:
 * You may assume that both strings contain only lowercase letters. 
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<ransomNote.length();i++){
            if(!map.containsKey(ransomNote.charAt(i))){
                map.put(ransomNote.charAt(i), 1); 
            }
            else map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))+1);//+1 was in the wrong bracket...
        }
        Map<Character,Integer> map2=new HashMap<Character,Integer>();
        for(int i=0;i<magazine.length();i++){
            if(!map2.containsKey(magazine.charAt(i))){
                map2.put(magazine.charAt(i), 1);                
            }
            else map2.put(magazine.charAt(i), map2.get(magazine.charAt(i))+1);//forgot to change map to map2...
        }
        for(int i=0;i<ransomNote.length();i++){
            System.out.println(map2.get(ransomNote.charAt(i))+" "+map.get(ransomNote.charAt(i)));
            if(!map2.containsKey(ransomNote.charAt(i))||map2.get(ransomNote.charAt(i))<map.get(ransomNote.charAt(i))){
                return false;
            }
        }
        return true;
        
    /**
     * the following solution is meant for the second string will have the same order as the first string
     */
    /*    int index=0;
        if(ransomNote.equals("")==false&&magazine.equals(""))return false;
        for(int i=0;i<ransomNote.length();i++){
            //System.out.println("outer");
            if(index==magazine.length())return false;//!!!
            for(int j=index;j<magazine.length();j++){
                //System.out.println("inner");
                //System.out.println(ransomNote.charAt(i)+" "+magazine.charAt(j));
                if(ransomNote.charAt(i)==(magazine.charAt(j))){
                    System.out.println("***in if");
                    index=j+1;//!!!
                    System.out.println(index);
                    break;
                }
                if(j==magazine.length()-1)return false;
            }
        }
        return true;*/
    }
    public static void main(String[] args) {
        //System.out.println(new RansomNote383().canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
        //System.out.println(new RansomNote383().canConstruct("aa", "ab"));
        System.out.println(new RansomNote383().canConstruct("aa", "aab"));
        //System.out.println(new RansomNote383().canConstruct("bjaajgea", "affhiiicabhbdchbidghccijjbfjfhjeddgggbajhidhjchiedhdibgeaecffbbbefiabjdhggihccec"));
    }

}
