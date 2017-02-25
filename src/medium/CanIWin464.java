package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanIWin464 {
    /*map does not need backtracking setting
    so make it global var instead of argument in dfs()
    key is the path, value is the outcome*/
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    //declare and initialize an array recording which chooseable int are used.
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //corner cases
        int sum = (1+maxChoosableInteger) * maxChoosableInteger / 2;
        if(sum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        
        used = new boolean[maxChoosableInteger + 1];
        //one element longer, so no need to i +/- 1 later, will be faster
        return dfs(desiredTotal);
    }
    /*the key to put in the map should be the original one
    so it is better for the outest if-statement to be map.containsKey()*/
    private boolean dfs(int total) {
        int key = format(used);
        if(!map.containsKey(key)){
            for(int i = 1; i < used.length; i++){
                if(!used[i]) {
                    if(i >= total) return true;
                    used[i] = true;
                    if(!dfs(total - i)){
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);//not always false because the map may already contains this key
    }
    private int format(boolean[] used) {
        int num = 0;
        for(boolean b : used) {
            num = num << 1; //shift by one, i.e. add 0 to the end
            if(b) num = num | 1; //if true, set last bit to be 1
        }
        return num;
    }
    /**TLE Method*/
    /*public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int i = 1; i <= maxChoosableInteger; i++) {
            map.put(i, false);
        }
        return dfs(map, desiredTotal);
    }
    private boolean dfs(Map<Integer, Boolean> map, int total) {
        for(int i : map.keySet()) {
            if(map.get(i)) continue; //if it has been used, continue
            if (i >= total) {
                return true;
            }
            else {
                map.put(i, true);
                if(!dfs(map, total - i)) {
                    map.put(i, false);
                    //should set back before return because it will change outer recurrsion's value
                    return true;
                }
                map.put(i, false);
            }
        }
        return false;
    }*/
    
    /**TLE method, cannot pass 5,20, can pass 10,40*/
    /*public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1; i <= maxChoosableInteger; i ++) {
            set.add(i);
        }
        return dfs(set, desiredTotal);
    }
    private boolean dfs(Set<Integer> set, int total) {
        System.out.println(total + " " + set.size());
        for(int i : set) {
            System.out.println("***" + i);
            if (i >= total) return true;
            else {
                Set<Integer> set2 = new HashSet<Integer>(set);
                set2.remove(i);
                if(!dfs(set2, total - i)) return true;
            }
        }
        return false;
    }*/
    public static void main(String[] args) {
        CanIWin464 x = new CanIWin464();
        System.out.println(x.canIWin(5, 20));
    }

}
