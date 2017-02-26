package medium;

public class RotateImage48 {
    // \ D           C          C         
    // C \ A   =>  D | B   => B   D
    //   B \         A          A
    public void rotate2(int[][] matrix) {
        //   D           C          C         
        // C   A   =>  D   B   => B   D
        //   B           A          A
        int n = matrix.length;
        //transpose \
        for(int p = 0; p < n; p++) { 
            for(int i = p; i < n; i++) {
                //swap(matrix[i][q], matrix[q][i]);
                int tmp = matrix[p][i];
                matrix[p][i] =  matrix[i][p];
                matrix[i][p] = tmp;
            }
        }
        //flip |
        for(int p = 0; p < n / 2; p++) {
            int q = n - 1 - p;
             for(int i = 0; i < n; i++) { //go through each row
                //swap(matrix[i][q], matrix[q][i]);
                int tmp = matrix[i][q];
                matrix[i][q] =  matrix[i][p];
                matrix[i][p] = tmp;
            }
        }
        
    }
    
    
    
    
    //wrong one
    public void rotate(int[][] matrix) {
        //   D           C          C         
        // C   A   =>  D   B   => B   D
        //   B           A          A
        //A swap with B, C swap with D, then B swap with D
        int n = matrix.length;
        //from outside to inside
        for(int p = 0; p < n / 2; p++) { //p is moving from outside in
            int q = n - 1 - p;
            for(int i = 0; i < n; i++) {
                //swap A, B
                // swap(matrix[i][q], matrix[q][i]);
                int tmp = matrix[i][q];
                matrix[i][q] =  matrix[q][i];
                matrix[q][i] = tmp;
                //swap C, D
                // swap(matrix[i][p], matrix[p][i]);
                tmp = matrix[i][p];
                matrix[i][p] =  matrix[p][i];
                matrix[p][i] = tmp;
            }
            for(int i = 0; i < n; i++) {
                //swap B, D
                // swap(matrix[i][p], matrix[i][q]);
                int tmp = matrix[i][p];
                matrix[i][p] =  matrix[i][q];
                matrix[i][q] = tmp;
            }
            //swap upleft and bottomright
            int tmp = matrix[p][p];
            matrix[p][p] =  matrix[q][q];
            matrix[q][q] = tmp;
        }
    }
    private void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

}
