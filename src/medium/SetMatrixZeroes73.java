package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes73 {
  //Second time, O(m) space, beat 91%
    public void setZeroes2(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int row = matrix.length; //m
        int col = matrix[0].length; //n
        boolean[] colMark = new boolean[col]; //mark which columns to be 0
        //set rows to zero and mark cols to be set
        for(int r = 0; r < row; r++) { //use for each loop here can't change the original value, for each loop is using Iterator
            boolean rowIsZero = false;
            for(int c = 0; c < col; c++) {
                if(matrix[r][c] == 0) {
                    colMark[c] = true;
                    rowIsZero = true;
                }
            }
            if(rowIsZero) Arrays.fill(matrix[r], 0); 
        }
        //set columns to be zeros
        for(int i = 0; i < col; i++) {
            if(colMark[i]) {
                for(int[] r : matrix) {
                    r[i] = 0;
                }
            }
        }
    }
    
    
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
