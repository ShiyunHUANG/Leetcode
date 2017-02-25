package easy;

import java.util.ArrayList;
import java.util.Stack;

public class ValidParenthesis20 {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> left = new Stack<Character>();
        if (arr.length == 0) {
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr.length %2 != 0) {
                return false;
            }
            if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
                left.push(arr[i]);
            } else if (left.isEmpty()) {
                return false;
            }  else if (!isPair(left.pop(), arr[i])) {
               return false;
            }
        }
        if (!left.isEmpty()) {
            return false;
        }
        return true;

    }
    private boolean isPair(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        } else if (a == '[' && b == ']') {
            return true;
        } else if (a == '{' && b == '}') {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        ValidParenthesis20 x = new ValidParenthesis20();
        System.out.println(x.isValid("()[]()"));
    }

}
