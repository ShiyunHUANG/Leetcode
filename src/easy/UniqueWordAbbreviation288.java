package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueWordAbbreviation288 {
    private UniqueWordAbbreviation288 vwa;
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    public UniqueWordAbbreviation288(String[] dictionary) {
        for(String d : dictionary) {
            String abbr = getAbbr(d);
            if(!map.containsKey(abbr)) {
                List<String> list = new ArrayList<String>();
                list.add(d);
                map.put(abbr, list);
            } else {
                List<String> list = map.get(abbr);
                if(!list.contains(d)) list.add(d);
            }
        }
    }

   public boolean isUnique(String word) {
        if (map.isEmpty()) return true;
        String abbr = getAbbr(word);
        if (!map.containsKey(abbr)) return true;
        else {
            return (map.get(abbr).size() == 1) && (map.get(abbr).contains(word));
        }
    }
    private String getAbbr(String str) {
        if(str.trim().equals("")) return "";
        String mid = str.length() > 2 ? String.valueOf(str.length() - 2) : ""; //Integer.toString(...);
        return str.charAt(0) + mid + str.charAt(str.length() - 1);
    }
}

//Your ValidWordAbbr object will be instantiated and called as such:
//ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
//vwa.isUnique("Word");
//vwa.isUnique("anotherWord");