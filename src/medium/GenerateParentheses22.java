package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return res;
    }
    private void dfs(String str, int left, int right, int n) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }
        if (left < n) {
//            str = str + "("; // !!!WRONG
//            dfs(str, left + 1, right, n);
            String another = str + "(";
            dfs(another, left + 1, right, n);
            
        }
        if (right < left) {
            dfs(str + ")", left, right + 1, n);
        }
    }
    public static void main(String[] args) {
        GenerateParentheses22 x = new GenerateParentheses22();
        System.out.println(x.generateParenthesis(3));
    }
}
