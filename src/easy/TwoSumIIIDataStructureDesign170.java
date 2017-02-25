package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumIIIDataStructureDesign170 {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public void add(int number) {
        if(map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }
    public boolean find (int value) {
        for (int num1 : map.keySet()) {
            int num2 = value - num1;
            if (num1 == num2 && map.get(num1) > 1) {
                return true;
            }
            else if (num1 != num2 && map.containsKey(num2)) {
                return true;
            }
        }
        return false;
    }
    
    /**correct but TLE example. Use hashmap/set will be faster*/
/*    List<Integer> list = new ArrayList<Integer>();
    // Add the number to an internal data structure.
    public void add(int number) {
        list.add(number);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        list.sort((i1, i2)-> i1 - i2);
//        System.out.println(list);
        for(int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
//                System.out.println("i " + i + " j " + j + " : " + (list.get(i) + list.get(j)));
                if (list.get(i) + list.get(j) == value) return true;
                else if (list.get(i) + list.get(j) > value) break;
            }
        }
        return false;
    }*/
    public static void main (String[] args) {
        TwoSumIIIDataStructureDesign170 x = new TwoSumIIIDataStructureDesign170();
        x.add(0);
        x.add(0);
        x.add(1);
        x.add(0);
        System.out.println("res "+x.find(9));
    }

    // Your TwoSum object will be instantiated and called as such:
    // TwoSum twoSum = new TwoSum();
    // twoSum.add(number);
    // twoSum.find(value);
}
