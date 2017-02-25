package easy;

import java.math.BigInteger;

public class FactorialTrailingZeroes172 {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 0; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i)) ;
        }
        System.out.println(factorial);
        int res = 0;
        while (factorial.compareTo(BigInteger.valueOf(9)) == 1) {
            if (factorial.mod(BigInteger.valueOf(10)).compareTo(BigInteger.valueOf(0)) == 0) {
                res++;
            } else {
                return res;
            }
            factorial = factorial.divide(BigInteger.valueOf(10));
        }
        return res;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
