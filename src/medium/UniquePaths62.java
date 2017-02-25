package medium;

public class UniquePaths62 {
    /**MY AC DP solution*/
    public int uniquePaths(int m, int n) {
        //m - 1 steps down, n - 1 steps right
        //sub problems are: for each grid, if it is destination, 
        //the value is adding up the paths from bottom and from left
            int[][] map = new int[m][n];
            //fill in 1 for (m - 1 == 0) || (n - 1 == 0) 
            for(int x = 0; x < m; x++) map[x][0] = 1;
            for(int y = 1; y < n; y++) map[0][y] = 1;
            for(int x = 1; x < m; x++) {
                for(int y = 1; y < n; y++) {
                    map[x][y] = map[x - 1][y] + map[x][y - 1];
                }
            }
            return map[m - 1][n - 1];
        }
    /**My DFS TLE solution*/
    int res = 0;
    public int uniquePaths2(int m, int n) { 
    //m - 1 steps down, n - 1 steps right
        dfs(m - 1, n - 1);
        return res;
    }
    private void dfs(int a, int b) {
        if(a == 0 || b == 0) {
            res++;
            return;
        }
        dfs(a - 1, b);
        dfs(a, b - 1);
    }
}
