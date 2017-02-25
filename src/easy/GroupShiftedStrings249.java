package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for(String s: strings) {
            if(map.containsKey(s.length())) {
                map.get(s.length()).add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(s.length(), list);
            }
        }
        for(List<String> list : map.values()) {
            System.out.println(list);
            Map<String, List<String>> local = new HashMap<String, List<String>>();
            for(String str : list) {
                if(str.length() == 1) {
                    local.put("", list);
                    break;
                }
                String key = getChar(str);
                if(local.containsKey(key)) {
                    local.get(key).add(str);
                } else {
                    List<String> newList = new ArrayList<String>();
                    newList.add(str);
                    local.put(key, newList);
                }
            }
            res.addAll(local.values());
        }
        return res;
    }
    private String getChar(String str) {
        char[] arr = str.toCharArray();
        int[] res = new int[arr.length - 1];
        for(int i = 1; i < arr.length; i++) {
            int bit = arr[i] - arr[i - 1];
            if (bit < 0) {
                bit += 26;
            }
            res[i - 1] = bit;
        }
        return Arrays.toString(res);
    }
}

/**
 * others good solution
*/
/*
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        if(strings.length < 1 || strings == null) return new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strings){
            char[] chars = s.toCharArray();
            char start = chars[0];
            int gap = start - 'a'; // - gap to every char in chars and make sure chars[0] is 'a'
            for(int i = 0; i < chars.length; i++){
                chars[i] -= gap;
                if(chars[i] < 'a'){
                    chars[i] += 26;
                }
            }
            String key = String.valueOf(chars);
            if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

*/