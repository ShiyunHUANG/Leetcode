package medium;

public class UniquePaths63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] map = new int[row][col];
        for(int x = 0; x < row; x++) {
            boolean bX = (x == 0);
            for(int y = 0; y < col; y++) {
                boolean bY = (y == 0);
                if(obstacleGrid[x][y] == 1) {
                    map[x][y] = 0;
                    continue;
                }
                int val = 0;
                if(!bX) val = val + map[x - 1][y];
                if(!bY) val = val + map[x][y - 1];
                if(bX && bY) map[x][y] = 1;
                else map[x][y] = val;
            }
        }
        return map[row - 1][col - 1];
    }
}
