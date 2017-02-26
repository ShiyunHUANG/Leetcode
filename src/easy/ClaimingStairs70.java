package easy;

public class ClaimingStairs70 {
    public int climbStairs(int n) {
        //2 scenarios: last step is 1, last step is 2
        int[] dp = new int[n + 1]; //number of methods for each stair number
        if (n == 1) return 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];        
    }
}
