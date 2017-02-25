package medium;

public class GuessNumberHigherOrLowerII375 {
//top down recurrsive dp
    public int getMoneyAmount(int n) {
        int[][] table = new int[n + 1][n + 1];
        return dp(table, 1, n);
    }
    private int dp(int[][] table, int start, int end) {
        if(start >= end) return 0; //>=, not just ==
        if(table[start][end] != 0) return table[start][end];
        int min = Integer.MAX_VALUE;
        for(int pick = start; pick < end; pick++) {
            int luck = pick + Math.max(dp(table, start, pick - 1), dp(table, pick + 1, end));//worst luck
            min = Math.min(min, luck);//best choice
        }
        table[start][end] = min;
        return min;
    }
    //bottom up
    public int getMoneyAmount2(int n) {
        int[][] table = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i+1==j?i:globalMin;
            }
        }
        return table[1][n];
    }
}
