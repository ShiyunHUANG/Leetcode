package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak139 {
    //s can use wordDict element more than once
    //s and wordDict are non-empty
    
    
    /**DP solution*/
    public boolean wordBreak2(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        int len = s.length();
        boolean[] dp = new boolean[len + 1]; //!!!len + 1 not length
        dp[0] = true; //substring nothing
        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
        
    }
    /*My cant pass corner case solution*/
    private boolean res = false;
    public boolean wordBreak3(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        Map<Integer, Map<Integer, Boolean>> map = new HashMap<>(); //1st idx, 2nd index, inDict?
        dfs(0, 1, s, wordDict, map);
        return res;
    }
    private void 
    dfs(int start, int end, String s, List<String> dict, Map<Integer, Map<Integer, Boolean>> map) {
        if(start == s.length()) {
            res = true;
            return;
        }
        if(end > s.length()) return;
        if(validate(start, end, map, dict, s)) dfs(end, end + 1, s, dict, map);
        else dfs(start, end + 1, s, dict, map);
    }
    private boolean validate
    (int start, int end, Map<Integer, Map<Integer, Boolean>> map, List<String> dict, String s) {
        if(map.containsKey(start)) {
            Map<Integer, Boolean> inner = map.get(start);
            if(inner.containsKey(end)) {
                return inner.get(end);
            }
            else {
                if(dict.contains(s.substring(start, end))) {
                    inner.put(end, true);
                    return true;
                } else {
                    inner.put(end, false);
                    return false;
                }
            }
        } else {
            Map<Integer, Boolean> inner = new HashMap<>();
            if(dict.contains(s.substring(start, end))) {
                inner.put(end, true);
                map.put(start, inner);
                return true;
            } else {
                inner.put(end, false);    
                map.put(start, inner);
                return false;
            }
        }
    }
    /**My TLE solution*/
    int len;
    public boolean wordBreak(String s, List<String> wordDict) {
        len = s.length();
        return dfs(0, 1, s, wordDict);

    }
    private boolean dfs(int p1, int p2, String s, List<String> dict) {
        if(p1 == len) return true;
        // if(p1 == 0 && p2 == len) return false;
        // System.out.println(p1 + " " + p2);
        String sub = s.substring(p1, p2);
        if(dict.contains(sub)) {
            if(dfs(p2, p2 + 1, s, dict)) return true;
        }
        //terminate recur condition
        if(p2 == len) return false;
        //if doesn't contain and not reach the end
        return dfs(p1, p2 + 1, s, dict);
    }
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(s.substring(4, 8));
    }

}
