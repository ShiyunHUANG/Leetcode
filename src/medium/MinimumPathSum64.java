package medium;

public class MinimumPathSum64 {
    public int minPathSum(int[][] grid) { //assume non-empty grid
        int rows = grid.length, cols = grid[0].length;
        int map[][] = new int[rows][cols];
        for(int x = 0; x < rows; x++) {
            boolean bX = (x == 0);
            for(int y = 0; y < cols; y++) {
                boolean bY = (y == 0);
                int ori = grid[x][y], val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;
                if(bX && bY) {
                    map[x][y] = ori;
                    continue;
                }
                if(!bX) val1 = ori + map[x - 1][y];
                if(!bY) val2 = ori + map[x][y - 1];
                map[x][y] = Math.min(val1, val2);
            }
        }
        return map[rows - 1][cols - 1];
    }
}
