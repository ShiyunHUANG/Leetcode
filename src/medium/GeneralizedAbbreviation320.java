package medium;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation320 {
    List<String> res = new ArrayList<>();
    public List<String> generateAbbreviations(String word) {
        char[] chArr = word.toCharArray();
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        dfs(chArr, 0, 0, sb);
        return res;
    }
    private void dfs(char[] chArr, int pos, int num, StringBuilder sb) {
        int original = sb.length();
        //terminate condition
        if(pos == chArr.length) {
            if(num > 0) {
                sb.append(num);
            }
            res.add(sb.toString());
        } else {
            //abbreviate the current char, not adding anything yet until NOT abbreviate
            dfs(chArr, pos + 1, num + 1, sb);
            //not abbreviate it, set the num to 0 if it isn't
            if(num > 0) {
                sb.append(num);
            }
            sb.append(chArr[pos]);
            dfs(chArr, pos + 1, 0, sb);
        }
        sb.setLength(original);//!!!
    }

}
