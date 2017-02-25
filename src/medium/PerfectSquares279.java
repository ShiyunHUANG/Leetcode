package medium;

public class PerfectSquares279 {
    public int numSquares(int n) { //n > 0
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            int min = i; //maximum is i steps
            int closestSqrt = (int) Math.sqrt(i);
            for(int sq = closestSqrt; sq >= 1; sq--) {
                int tmp = dp[i - sq * sq] + 1;
                //below two lines can't pass test case == 48
                // if(tmp > min) break; 
                // else min = tmp;
                min = min < tmp ? min : tmp;
            }
            dp[i] = min;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
