package medium;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix378 {
    public int kthSmallest(int[][] matrix, int k) {
        int length = Math.min(k, matrix.length);
        PriorityQueue<Ordinate> pq = new PriorityQueue<Ordinate>();
        for (int i = 0; i < length; i++) {
            pq.add(new Ordinate(0, i, matrix));
        }
        for (int i = 0; i < k - 1; i++) {
            Ordinate temp = pq.poll(); 
            //temp is the current smallest element
            if (temp.x == matrix.length - 1) { //last row, don't add anymore.
                continue;                
            }
            else {
                pq.add(new Ordinate(temp.x + 1, temp.y, matrix)); 
                //add an element that is below the current smallest element
            }
        }
        return pq.poll().val;
    }
    class Ordinate implements Comparable<Ordinate> {
        int x, y, val;
        public Ordinate(int x, int y, int[][] matrix) {
            this.x = x;
            this.y = y;
            val = matrix[x][y];
        }
        @Override
        public int compareTo(Ordinate next) {// should be public
            return this.val - next.val;
        }
    }
}
/*
 * //notice it is square.
        int min = matrix[0][0];
        if (matrix.length == 1) return min;
        int x1 = 1, y1 = 0;
        int x2 = 0, y2 = 1;
        int x3 = n - 1, y3 = n - 1;
        int count = 0;
        while (count < k) {
            if (matrix[x1][y1] < matrix [x2][y2]) {
                min = matrix[x1][y1];

            } else {
                min = matrix[x2][y2];
            }
            count++;
        }
        return min;
    }
    private void move(int x, int y) {
        if (x == n - 1 && y == n - 1) return;
        if (x == n - 1 || matrix[x][y + 1] < matrix[x + 1][y]) {
            if (x != n - 1) {
                x3 = x + 1;
                y3 = y;
            }
            y = y + 1;
        } else {
            if (y != n - 1) {
                x3 = x;
                y3 = y + 1;                
            }
            x = x + 1;
        }
    } */
