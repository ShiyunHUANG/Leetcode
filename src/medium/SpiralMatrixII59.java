package medium;

public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int lft = 0, rgt = n - 1, up = 0, dwn = n - 1;
        int x, y, i = 1;
        while(i <= n * n) {
            for(x = up, y = lft; y <= rgt; y++) {
                res[x][y] = i;
                i++;
            }
            up++;
            if(up > dwn) break;
            for(x = up, y = rgt; x <= dwn; x++) {
                res[x][y] = i;
                i++;
            }
            rgt--;
            if(lft > rgt) break;
            for(x = dwn, y = rgt; y >= lft; y--) {
                res[x][y] = i;
                i++;
            }
            dwn--;
            if(up > dwn) break;
            for(x = dwn, y = lft; x >= up; x--) {
                res[x][y] = i;
                i++;
            }
            lft++;
            if(lft > rgt) break;
        }
        return res;
    }
}
