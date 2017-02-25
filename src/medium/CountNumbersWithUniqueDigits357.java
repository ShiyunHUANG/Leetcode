package medium;

public class CountNumbersWithUniqueDigits357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;//special case
        int res = 10; // result for n == 1
        int available = 9;
        int factorial = 9;
        for(int i = 2; i <= Math.min(n, 10); i++) {
            factorial = available * factorial;
            res = res + factorial;
            available--;
        }
        return res;
    }
}
