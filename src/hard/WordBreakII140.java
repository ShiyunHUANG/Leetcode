package hard;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII140 {
    //Feb 13 2017, AC 1!! Beat 11%...space is O(n)
    private List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return res;
        int len = s.length();
        //use a list to store list, don't use array to store list
        List<List<Integer>> idx = new ArrayList<List<Integer>>(len + 1);//record the idx of s here
        for(int i = 0; i <= len; i++) {
            idx.add(new ArrayList<Integer>());
        }
        idx.get(0).add(0);
        
        for(int i = 1; i < len + 1; i++) {
            for(int j = 0; j < i; j++) {
                if(!idx.get(j).isEmpty() && wordDict.contains(s.substring(j, i))) {
                    idx.get(i).add(j);
                }
            }
        }
        if(!idx.get(len).isEmpty()) {
            dfs(idx, s, len, "");
        }
        return res;
    }
    private void dfs(List<List<Integer>> idx, String s, int curr, String sb) {
        if(curr == 0) {
            res.add(sb.substring(0, sb.length() - 1)); //the last char is a space
            return;
        }
        for(int i : idx.get(curr)) {
            dfs(idx, s, i, s.substring(i, curr) + " " + sb);
        }
    }
    
    
    //2nd try, TLE
    //"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    //["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    private List<String> res2 = new ArrayList<>();
    public List<String> wordBreak2(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return res;
        int len = s.length();
        //use a list to store list, don't use array to store list
        List<List<String>> idx = new ArrayList<List<String>>(len + 1);//record the idx of s here
        for(int i = 0; i <= len; i++) {
            idx.add(new ArrayList<String>());
        }
        idx.get(0).add("");
        
        for(int i = 1; i < len + 1; i++) {
            for(int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if(!idx.get(j).isEmpty() && wordDict.contains(sub)) {
                    for(String ss : idx.get(j)) { //THIS TOOK TOO LONG
                        idx.get(i).add(ss + " " + sub);
                    }
                }
            }
        }
        for(String ss : idx.get(len)) {
            res.add(ss.substring(1)); //the first char is space
        }
        return res2;
    }

}
