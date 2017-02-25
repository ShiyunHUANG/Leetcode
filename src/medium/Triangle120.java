package medium;

import java.util.List;

public class Triangle120 {
    public int minimumTotal(List<List<Integer>> triangle) { //assume non-empty
        //start from bottom
        int size = triangle.size();
        if(size == 1) return triangle.get(0).get(0);
        List<Integer> dp = triangle.get(size - 1);//the bottom/longest list in triangle
        for(int i = size - 2; i >= 0; i--) { //start from 1 from bottom to top
            List<Integer> list = triangle.get(i);//the list above dp
            for(int j = 0; j < list.size(); j++) {
                int a = list.get(j) + dp.get(j);
                int b = list.get(j) + dp.get(j + 1);
                dp.set(j, Math.min(a, b));
            }
        }
        return dp.get(0);
    }
}
