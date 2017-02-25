package easy;
import java.util.List;

// This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
  interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
 
public class NestedListWeightSum339 {
    int res = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        for (NestedInteger nl : nestedList) {
            depth(nl, 1);
        }
        return res;
    }
    private void depth(NestedInteger ni, int depth) {
        if (!ni.isInteger()) {
            List<NestedInteger> list = ni.getList();
            for (NestedInteger i : list) {
                depth(i, depth + 1);                
            }
        } else {
            res += ni.getInteger() * depth;
        }
    }
}
