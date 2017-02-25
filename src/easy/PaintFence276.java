package easy;

public class PaintFence276 {
    public int numWays(int n, int k) {
        if (n == 1) return k;
        if (k == 0 || n == 0)  return 0;
        //n!=1 or 0 now
        if (k == 1) {
            if (n == 2) return 1;
            else return 0;
        }
        
        int res = k *(helper(true, 1, n - 1, k) + helper(false, 1, n - 1, k));
        return res;
    }
    private int helper(boolean same, int i, int bound, int k) {
        //don't use == 1 to decide, because when k == 2, same or not both == 1
        if (i == bound) {
            if (same) return 1;
            else return k - 1; // x = k - 1 
        }
        else {
            if (same) return helper(false, i + 1, bound, k);
            else return (k - 1) * (helper(true, i + 1, bound, k) + helper(false, i + 1, bound, k)); 
        }
    }
}
