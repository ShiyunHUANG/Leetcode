package medium;
//Out of time limit. Math problem. Can just return sqrt(n)
public class BulbSwitcher319 {
    public int bulbSwitch(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        //n >= 3
        boolean [] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                b[i] = true;
            } else {
                b[i] = false;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j * i - 1 < n; j++) {
                b[j * i - 1] = !b[j * i - 1];
            }
        }
        int res = 0;
        for (boolean bl : b) {
            if (bl == true) res++;
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
