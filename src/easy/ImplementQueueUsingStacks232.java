package easy;

import java.util.Stack;

/**
 * You must use only standard operations of a stack --
 * which means only push to top, peek/pop from top, size, 
 * and is empty operations are valid.
 * @author huang
 */
public class ImplementQueueUsingStacks232 {
    public static void main(String[] args) {
    }
}
class MyQueue {
    Stack<Integer> myQueue=new Stack<Integer>();
    Stack<Integer> temp=new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        while(!myQueue.empty()){
            temp.push(myQueue.pop());
        }
        myQueue.push(x);
        while(!temp.empty()){
            myQueue.push(temp.pop());
        }
        
    }

    // Removes the element from in front of queue.
    public void pop() {
        myQueue.pop();
    }

    // Get the front element.
    public int peek() {
        return myQueue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return myQueue.empty();
    }
}