package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the 
 * sum of the squares of its digits, and repeat the process until 
 * the number equals 1 (where it will stay), or it loops endlessly 
 * in a cycle which does not include 1. Those numbers for which 
 * this process ends in 1 are happy numbers.
 * 
Example: 19 is a happy number
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * @author Shiyun Huang
 *
 */
public class HappyNumber202 {
    public boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        }
        /*set result to input number, if n > 1, go into the while loop*/
        int res = n;
        /*Unhappy number will appear in loop, use HashSet to find repetitive number*/
        Set<Integer> set = new HashSet<Integer>();
        /*The loop ends when res = 1 or when repetitive number appear*/
        while (res > 1){
            if(!set.add(res)){
                return false;
            }
            set.add(res);
            res = SquareOfDigits (res);
        }
        return true;
    }
    /*The following method add up the square of digits of input number*/
    private int SquareOfDigits (int n) {
        int sum = 0;
        while (n > 0){
            sum = sum + (int) Math.pow(n%10, 2);
            System.out.println("digit: " + n % 10);
            n = n/10;            
        }
        System.out.println("Sum: "+ sum);
        return sum;
    }
    public static void main(String[] args) {
        boolean x = new HappyNumber202().isHappy(7);
        System.out.println(x);
    }

}
