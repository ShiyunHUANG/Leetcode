package medium;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree96 {
    public int numTrees(int n) {
        //a list recording the values numTrees givin n.
        List<Integer> list = new ArrayList<Integer>();//can use array here since length is known
        list.add(1); //n = 0 has 1 tree
        list.add(1); //n = 1 has 1 tree
        int res = 1;
        for (int i = 2; i < n + 1; i++) {
            res = 0;
            for (int j = 1; j <= i / 2; j++) {
                res += 2 * (list.get(j - 1) * list.get(i - j));
            }
            if (i % 2 == 1) {
                res += list.get(i / 2) * list.get(i / 2);
            }
            list.add(res);
            // System.out.println(list);
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
