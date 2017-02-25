package easy;

import java.util.Stack;

public class MinStack155 {
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack155() {
        stack = new Stack<Integer>();
        stack.push(min);
    }
    
    public void push(int x) {
        if (x <= min) {//!!!!!!!!!MUST BE <= nor <, always remember what the last min is.
            stack.push(min);//old min
            min = x;
        }
        stack.push(x);//new min
    }
    
    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.peek();
        }
        stack.pop();
    }
    
    public int top() {
       return stack.peek(); 
    }
    
    public int getMin() {
        return min;
    }
}
