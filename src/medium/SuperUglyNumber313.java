package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are 
 * in the given prime list primes of size k. For example, 
 * [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the 
 * first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4. 
 * Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000. 
(4) index n is NOT zero-based.
 *
 */
public class SuperUglyNumber313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1; // default to be 0
        int[] p = new int[primes.length]; // arr of pointers in ugly[]
//        Arrays.fill(p, 0); // not necessary?
        int ct = 1; // count of ugly numbers
        while(ct < n) {
            int min = Integer.MAX_VALUE; 
            List<Integer> minPointers = new ArrayList<Integer>();
            for(int i = 0; i < p.length; i++) {
                int multi = ugly[p[i]] * primes[i];
                if(multi <= min) {
                    if(multi < min) minPointers.clear(); 
                    minPointers.add(i);
                    min = multi;
                }
            }
            ugly[ct] = min;
            ct++;
            for(int i : minPointers) {
                p[i]++;
            }
        }
        return ugly[n - 1];
    }
    public static void main(String[] args) {

    }

}
