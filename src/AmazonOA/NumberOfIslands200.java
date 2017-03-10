package AmazonOA;

public class NumberOfIslands200 {
    private char[][] g = null;
        public int numIslands(char[][] grid) {
            //dfs and marked visited grid to 0
            if(grid == null || grid.length == 0) return 0;
            int row = grid.length;
            int col = grid[0].length;
            g = grid;
            int res = 0;
            for(int r = 0; r < row; r++) {
                for(int c = 0; c < col; c++) {
                    if(grid[r][c] == '1') {
                        res++;
                        dfs(r, c, row, col);
                    }
                }
            }
            return res;
        }
        private void dfs(int r, int c, int row, int col) {
            if(r >= row || c >= col || r < 0
                || c < 0 || g[r][c] == '0') return;
            g[r][c] = '0'; //drown the island
            //check four directions
            dfs(r + 1, c, row, col);
            dfs(r, c + 1, row, col);
            dfs(r - 1, c, row, col); //must have
            dfs(r, c - 1, row, col); //must have
        }
}

