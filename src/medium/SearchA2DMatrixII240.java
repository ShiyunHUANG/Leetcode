package medium;

public class SearchA2DMatrixII240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int colN = matrix[row].length; // number of colomns
        int rowN = matrix.length;//number of rows
        if (target < matrix[0][0] || target > matrix [rowN - 1][colN - 1]) {
            return false;
        }
        int low = 0;
        int high = colN - 1;
        int curr = (high + low) / 2; // !!!is + not -....
        while (low <= high) { //!!
            curr = (high + low) / 2;
            if (target < matrix[row][curr]) {
                high = curr - 1; // !! - 1
            } else if (target > matrix[row][curr]) {
                low = curr + 1; // !! + 1
            } else {
                return true;
            }
        }
        if (high == curr - 1) { // target < curr
            curr--;
        } 
        // else low = curr + 1;
        //start from smaller to find big
        //go down until bigger, then go left
OUTER:      while (row < rowN - 1) {
            row++;
            // System.out.println("row " + row  + " curr " + curr);
            if (target < matrix[row][curr] && row < rowN) { //should go left now
                while (curr > 0) {
                    curr--;
                    // System.out.println("** curr " + curr + " row " + row);
                    if (target == matrix[row][curr]) return true;
                    if (target > matrix[row][curr]) continue OUTER;
                }
                // return false;//delete this, let the row goes down.
            } else if (target == matrix[row][curr]) {
                return true;
            }
        }
        //final row
        while (curr < colN - 1) {
            curr++;
            if (target == matrix[row][curr]) return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }

}
