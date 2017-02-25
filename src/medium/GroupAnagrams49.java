package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            } else {
                map.get(key).add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
