package medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<String>());
        return res;
    }
    private void dfs(String str, List<String> path) {
        //terminate condition
        if(str.length() == 0){//
          res.add(new ArrayList<String>(path));
          return;  
        }
        //loop and recurrsion
        for(int i = 1; i <= str.length(); i++) {
            String sub = str.substring(0, i);
            if(isPalindrome(sub)) {
                path.add(sub);
                dfs(str.substring(i), path);
                path.remove(path.size() - 1);//remove if just added   
            }
        }
    }
    /*List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, 1, new ArrayList<String>(), false);
        return res;
    }
    private void dfs(String str, int start, int end, List<String> path, boolean added) {
        System.out.println("****" + start + "****" + end +"****" + added + "****");
        String sub = str.substring(start, end);
        boolean subIsPal = isPalindrome(sub);
        System.out.println(sub + " is pal? " + subIsPal);
        //terminate condition
        if(end == str.length()){//
          if(subIsPal) {
            if(!added) path.add(sub);//bug
            res.add(new ArrayList<String>(path));
            System.out.println("add this:" + path);
            if(!added) path.remove(sub);
          }
          return;  
        }
        //end at this char
        if(subIsPal) {
            path.add(sub);//if added here should remove later
            System.out.println("now: " + path);
        }
        dfs(str, end, end + 1, path, false);
        //continue at this char
        if(subIsPal) {
            path.remove(path.size() - 1);//remove if just added
            System.out.println("removed " + path);
        }
        dfs(str, start, end + 1, path, true);
    }*/
    private boolean isPalindrome(String str) {
        int p1 = 0, p2 = str.length() - 1;
        while(p1 <= p2) {
            if(str.charAt(p1) != str.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }
}