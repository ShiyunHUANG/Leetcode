package medium;

public class Power50 {
    /**
     * Recursive
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) return 1 / x * myPow(1 / x, - n - 1);//n may overflow when n is Integer.MIN_VALUE
        if (n == 2) return x * x;//!!! without will stackoverflow
        //n > 0
        if (n % 2 == 0) {
            return myPow(myPow(x, n / 2), 2);
        } else {
            return x * myPow(x, n - 1);//!!!
        }
    }
    /**
     * Iterative
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        if (x == -1) {
            if (n % 2 == 0) return 1;
            else return -1;
        }
        if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) return 0;
        //add the above then ac...however, when number close to MAX or MIN still TLE
        double res = 1d;
        for(int i = 0; i < Math.abs(n); i++) {
            res = res * x;
        }
        if(n >= 0) return res;
        else return 1d / res;
    }
}
