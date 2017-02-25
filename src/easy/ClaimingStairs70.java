package easy;

public class ClaimingStairs70 {
    public int climbStairs(int n) {
        int set;
        int twos = 0;
        int ones = n - twos;
        if (n % 2 == 0){
            set = n / 2 + 1;//odd
        }
        else {
            set = (n + 1) / 2;//even
        }
        return ones;//temp

    }
}
