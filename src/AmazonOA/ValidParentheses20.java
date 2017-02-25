package AmazonOA;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//easy
public class ValidParentheses20 {
    /*Fast solution*/
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
    /*My slow solution, can just put right parenthese when meet left*/
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;//corner case
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        if(arr.length % 2 == 1) return false; //is % not /
        
        Set<Character> left = new HashSet<>();
        left.add('(');
        left.add('[');
        left.add('{');
        
        for(char ch: arr) {
            if(left.contains(ch)) stack.push(ch);
            else {
                if(stack.isEmpty() || !isPair(stack.pop(), ch)) return false; //empty stack exception
            }
        } 
        return stack.isEmpty(); //need to check if stack is empty, not just true
    }
    private boolean isPair(char left, char right) {
        if(left == '{') return right == '}';
        if(left == '[') return right == ']';
        return right == ')';
    }
    
}
