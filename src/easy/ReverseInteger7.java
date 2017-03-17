package easy;

public class ReverseInteger7 {
    //beat 82%
    //handle overflow: 1534236469, -2147483412
    public int reverse(int x) {
        boolean b = x < 0;
        if(b) x = -x;
        int res = 0;
        while(x > 0) {
            int digit = x % 10;
            if(res + digit / 10.0 > Integer.MAX_VALUE / 10.0) return 0; //handle overflow
            res = 10 * res + digit; //pay attention that no need to use stack here
            x = x / 10;
        }
        return b ? -res : res;
    }
}
