package medium;

//first turn all 'O' that is stick to the edge to 'A' in a dfs way
//then turn all 'O' to 'X', all 'A' to 'O'
public class SurroundedRegions130 {
    private int row, col;
    public void solve(char[][] board) {
        //remove two special case
        if(board == null || board.length <= 2) return;
        if(board[0].length <= 2) return;
        //store row and col in int
        row = board.length;
        col = board[0].length;
        //find 'O' that sticks to the edge
        for(int c = 0; c < col; c++) {
            if(board[0][c] == 'O') dfsO2A(0, c, board);
            if(board[row - 1][c] == 'O') dfsO2A(row - 1, c, board);
        }
        for(int r = 1; r < row - 1; r++) {
            if(board[r][0] == 'O') dfsO2A(r, 0, board);
            if(board[r][col - 1] == 'O') dfsO2A(r, col - 1, board);
        }
        //replace all 'O' with 'X' and 'A' with 'O'
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(board[r][c] == 'O') board[r][c] = 'X';
                if(board[r][c] == 'A') board[r][c] = 'O';
            }
        }
    }
    private void dfsO2A(int r, int c, char[][] board) {
        if(r < 0 || r > row || c < 0 || c > col) return;
        if(board[r][c] == 'O') board[r][c] = 'A';
        //careful to avoid stackoverflow, must have the if conditions, careful not to mix 0 with O
        //don't examine the edge or it will stackoverflow when huge?
        if(r - 1 >= 1 && board[r - 1][c] == 'O') dfsO2A(r - 1, c, board);
        if(r + 1 < row - 1 && board[r + 1][c] == 'O') dfsO2A(r + 1, c, board);
        if(c - 1 >= 1 && board[r][c - 1] == 'O') dfsO2A(r, c - 1, board);
        if(c + 1 < col - 1 && board[r][c + 1] == 'O') dfsO2A(r, c + 1, board);
    }
    //my wrong bfs, can't pass ["XXXX","XOOX","XXOX","XOXX"]
    public void solve2(char[][] board) {
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
                isTrapped(board, r, c + 1, row, col) &&
                (r - 1 < 0 || board[r - 1][c] == 'X') && //can't pass case
                (c - 1 < 0 || board[r][c - 1] == 'X');
                
                // &&
                // isTrapped(board, r - 1, c, row, col) &&
                // isTrapped(board, r, c - 1, row, col);
                if(res) board[r][c] = 'X';
            return res;
        }
    }
}
