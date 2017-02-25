package easy;

import java.util.LinkedList;
import java.util.Queue;
/**
 * You must use only standard operations of a queue -- which means only push to back,
 * peek/pop from front, size, and is empty operations are valid.
 * @author huang
 */

public class ImplementStackUsingQueues225 {

    public static void main(String[] args) {

    }
}
class MyStack {
    Queue<Integer> q=new LinkedList<Integer>();//MyStack
    Queue<Integer> temp=new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        while(!q.isEmpty()){
            temp.add(q.poll());
        }
        q.add(x);
        q.addAll(temp);
        temp.clear();
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        if (q.isEmpty()) return -1;
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}