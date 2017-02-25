package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes73 {
    public void setZeroes(int[][] matrix) {
        if(matrix == null) return;
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(matrix[x][y] == 0) {
                    rows.add(x);
                    cols.add(y);
                }
            }
        }
        for(int x : rows) {
            Arrays.fill(matrix[x], 0);
        }
        for(int y : cols) {
            for(int x = 0; x < m; x++) matrix[x][y] = 0;
        }
    }
}
