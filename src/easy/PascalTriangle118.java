package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<List<Integer>>();
        List<Integer> up = new ArrayList<Integer>();
        List<Integer> down;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        up.add(1);
        res.add(up);
        if (numRows == 1) return res;
        for (int row = 1; row < numRows; row++) {
            down = new ArrayList<Integer>();
            for (int i = 0; i < up.size() + 1; i++) {
                if(i==0||i==up.size()) {
                    down.add(1);
                } else {
                    System.out.println(up.get(i-1)+" "+up.get(i));
                    down.add(up.get(i-1)+up.get(i));
                }
            }
            res.add(down);  
            up = down;
        }
        return res;
    }
    public static void main(String[] args) {
        PascalTriangle118 x = new PascalTriangle118();
        System.out.println(x.generate(5));
    }

}
