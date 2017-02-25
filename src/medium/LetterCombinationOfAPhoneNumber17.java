package medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber17 {
    List<String> res = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        char[] inputChar = digits.toCharArray();
        List<Character> input = new ArrayList<Character>();
        for(char ch : inputChar) {
            if(lookUp(ch) != null) {
                input.add(ch);
            }            
        }
        if(input.size() == 0) return res;
        dfs(input, "", 0);
        return res;
    }
    private void dfs(List<Character> input, String path, int inputIdx) {
        if(path.length() == input.size()) {
            res.add(path);
            return;
        }
        char[] chArr = lookUp(input.get(inputIdx));
        for(int i = 0; i < chArr.length; i++) { //breath
            dfs(input, path + chArr[i], inputIdx + 1);
        }
    }
    private char[] lookUp(char ch) {
        switch(ch) {
            case '2': return new char[] {'a', 'b', 'c'};            
            case '3': return new char[] {'d', 'e', 'f'};
            case '4': return new char[] {'g', 'h', 'i'};
            case '5': return new char[] {'j', 'k', 'l'};
            case '6': return new char[] {'m', 'n', 'o'};
            case '7': return new char[] {'p', 'q', 'r', 's'};
            case '8': return new char[] {'t', 'u', 'v'};
            case '9': return new char[] {'w', 'x', 'y', 'z'};
            default: return null;
        }

    }
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        res.add(1);
        res.add(1);
//        res.get(0)++;//invalid
        res.set(0, res.get(0) + 1);
        for(int i : res) {
            i++;//nothing change
        }
        for(int i = 0; i < res.size(); i++) {
            
        }
        System.out.println(res);
    }

}
