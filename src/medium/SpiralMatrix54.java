package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int rows = matrix.length;
        if (rows == 0) return res;
        int cols = matrix[0].length;
        if (cols == 0) return res;
        int up = 0, dwn = rows - 1, lft = 0, rgt = cols - 1,
        x = 0, y = 0; //coordinate of current number
        while(up <= dwn && lft <= rgt) {
            for(x = up, y = lft; y <= rgt; y++) res.add(matrix[x][y]);
            up++;
            if(up > dwn) break; //everytime up/dwn/lft/rgt changes, needs to check this
            for(x = up, y = rgt;x <= dwn; x++) res.add(matrix[x][y]);
            rgt--;
            if(lft > rgt) break;
            for(x = dwn, y = rgt; y >= lft; y--) res.add(matrix[x][y]);//?
            dwn--;
            if(up > dwn) break;
            for(x = dwn, y = lft;x >= up; x--) res.add(matrix[x][y]);
            lft++;
        }
        return res;
    }
}
