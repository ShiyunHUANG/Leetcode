package easy;

import java.util.List;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits
 * it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 
 * 00000000000000000000000000001011, so the function should return 3.
 */
public class Numberof1Bits191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int count = 0;
       String str = Integer.toBinaryString(n);
       char[] charArray = str.toCharArray();
       for(char ch : charArray) {
           if(ch == '1') count++;
       }
       return count;
    }
    public static void main(String[] args) {
        Numberof1Bits191 x = new Numberof1Bits191();
        System.out.println(x.hammingWeight(11));
    }

}
