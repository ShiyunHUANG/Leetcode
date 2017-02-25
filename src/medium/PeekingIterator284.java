package medium;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator284 implements Iterator<Integer> {
 Iterator<Integer> iter;
 Integer curr = null; //like ListNode
 public PeekingIterator284(Iterator<Integer> iterator) {
     // initialize any member here.
     iter = iterator;
     if(iter.hasNext()) {
         curr = iter.next(); //keep the popped value;
     }
 }

 // Returns the next element in the iteration without advancing the iterator.
 public Integer peek() {
     return curr; //popped value
 }

 // hasNext() and next() should behave the same as in the Iterator interface.
 // Override them if needed.
 @Override
 public Integer next() {
     Integer res = curr;
     //move backwards
     if(iter.hasNext()) {
         curr = iter.next();
     } else curr = null;
     return res;
 }

 @Override
 public boolean hasNext() {
     return curr != null;
 }
}
