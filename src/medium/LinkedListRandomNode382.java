package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode382 {
    List<Integer> list;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode382(ListNode head) {
        list = new ArrayList<Integer>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int size = list.size();
        Random r = new Random();
        return list.get(r.nextInt(size));
    }
    
    /**Reservoir Sampling Solution*/
    /*ListNode head;
    *//** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. *//*
    public Solution(ListNode head) {
        this.head = head;
    }*/
    
    /** Returns a random node's value. */
    public int getRandom3() {
        ListNode curr = head;
        Random r = new Random();
        int res = curr.val;
        //think for 2 nodes case, choose between 0 and 1
        for(int i = 1; curr.next != null; i++) { 
            curr = curr.next;
            if(r.nextInt(i + 1) == i) res = curr.val; //i + 1 because exclusive
        }
        return res;
    }
    
    
    
    
    
    /**My without extra space but wrong solution*/
    ListNode curr, head;
    int bound = Integer.MAX_VALUE;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    /*public LinkedListRandomNode382(ListNode head) {
        this.head = head;
        curr = head;
    }*/
    /** Returns a random node's value. */
    public int getRandom2() {
        curr = head;
        Random r = new Random();
        for(int i = 0; i < r.nextInt(bound); i++) {
            if(curr.next == null) {
                bound = i + 1;
                curr.next = head;
            }
            curr = curr.next;
        }
        return curr.val;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */