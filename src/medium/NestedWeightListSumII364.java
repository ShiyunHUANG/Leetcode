package medium;

import java.util.List;

/**
 * NestedInteger is INTERFACE, but to make the code compile I changed to class here.
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }
    

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}


public class NestedWeightListSumII364 {
    int res = 0;
    int maxLvl = 1;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        depth(nestedList, 1);
        add(nestedList);
        return res;
    }
    private int depth(List<NestedInteger> list, int d) {
        for(NestedInteger nl : list) {
            if(!nl.isInteger()) {
                maxLvl = Math.max(depth(nl.getList(), d + 1), maxLvl);
            }
        }
        list.add(new NestedInteger(d));
        return d;
    }
    private void add(List<NestedInteger> list){
        for(int i = 0; i < list.size() - 1; i++) {
            int multi = maxLvl + 1 - list.get(list.size() - 1).getInteger();
            if(!list.get(i).isInteger()) {
                add(list.get(i).getList());
            } else {
                // System.out.println(multi);
                res = res + list.get(i).getInteger() * multi;                
            }
        }
    }
}
