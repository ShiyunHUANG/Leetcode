package easy;
/**
 * Given an integer, write a function to determine if it is a power of two. 
 * @author Shiyun Huang
 *
 */
public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }
        if (n <= 0){
            return false;
        }
        for ( ; n > 1 ; n = n / 2){
            if(n % 2 != 0){
                return false;
            }
        }
        return true;
     }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
