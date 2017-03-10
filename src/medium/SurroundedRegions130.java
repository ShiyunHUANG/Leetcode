package medium;

public class SurroundedRegions130 {
    //my wrong bfs
    public void solve(char[][] board) {
        //less than one row will never be surrounded
        if(board == null || board.length <= 1) return;
        int row = board.length;
        int col = board[0].length;
        for (int r = 1; r < row - 1; r++) {
            for(int c = 1; c < col - 1; c++) {
                isTrapped(board, r, c, row, col);
            }
        }
        
    }
    private boolean isTrapped (char[][] board, int r, int c, int row, int col) {
        boolean isEdge = (r < 0 || r > row - 1 || c < 0 || c > col - 1);
        if(isEdge) return false;
        // if(isEdge && board[r][c] == 'O') return false;
        if(board[r][c] == 'X') return true;
        else if((r == 1 && board[0][c] == 'O') || (c == 1 && board[r][0] == 'O')) return false;
        else {
            //going all 4 directions will stackoverflow (circle in it)
            boolean res = 
                isTrapped(board, r + 1, c, row, col) &&
                isTrapped(board, r, c + 1, row, col);// &&
                // isTrapped(board, r - 1, c, row, col) &&
                // isTrapped(board, r, c - 1, row, col);
                if(res) board[r][c] = 'X';
            return res;
        }
    }
}
