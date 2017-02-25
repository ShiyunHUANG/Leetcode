package medium;

public class GameOfLife289 {
    /**I was trying to reduce the amount of time to calculate neighbors, but too many corner cases */
    /*public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        int[] up = new int[n];
        int[] down = new int[n];
        if(m >= 2) {
            if(n == 1) {
                up[0] = board[0][0];
                down[0] = board[1][0];
            } else {
                up[0] = board[0][0] + board[0][1];
                up[n - 1] = board[0][n - 1] + board[0][n - 2];
                down[0] = board[1][0] + board[1][1];
                up[n - 1] = board[1][n - 1] + board[1][n - 2];
                for(int y = 1; y < n - 1; y++) {
                    up[y] = up[y - 1] + board[0][y + 1];
                    down[y] = down[y - 1] + board[1][y];
                    if(y >= 2) {
                        up[y] -= board[0][y - 2];
                        down[y] -= board[1][y - 2];
                    }
                }                            
            }
        }
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                int liveNum = 0;
                if(x > 0) liveNum += up[y];
                if(x < m - 1) liveNum += down[y];
                if(y > 0) liveNum += board[x][y - 1];
                if(y < n - 1) liveNum += board[x][y + 1];
                if(x < m - 2) {
                    if(y == 0) down[0] = board[x + 2][y];
                    else if(y == 1) down[0] += board[x + 2][y];
                    else if(y < n - 1)down[y - 1] = down[y - 2] + board[x + 2][y];
                    if(y )
                }
            }
            if(board[x][y] == 1) {
                
            } else {
                
            }
        }
    }*/
}
