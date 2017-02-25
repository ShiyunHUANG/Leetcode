package easy;

import java.util.ArrayList;
import java.util.List;

public class CountingPrimes204 {
    /**My slow ac method*/
    public int countPrimes(int n) {
        if(n <= 2) return 0; //1 is not prime number
        if(n == 3) return 1;
        List<Integer> primes = new ArrayList<Integer>(); //Set is no order
        primes.add(2);
OUT:    for(int i = 3; i < n; i++) {
            int sqrt = (int) Math.sqrt(i);
            for(int p : primes) {
               if(i % p == 0) continue OUT;
               if(p > sqrt) {
                   break;
               }
            }            
            primes.add(i);
        }
        return primes.size();
    }
}
