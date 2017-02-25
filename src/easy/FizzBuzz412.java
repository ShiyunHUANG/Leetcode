package easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
    List<String> res = new ArrayList<String>();
    public List<String> fizzBuzz(int n) {
        boolean b1, b2;
        for(int i = 1; i <= n; i++) {
            b1 = i % 3 == 0;
            b2 = i % 5 == 0;
            if(b1 && b2) {
                res.add("FizzBuzz");
            } else if (b1) {
                res.add("Fizz");
            } else if (b2) {
                res.add("Buzz");
            } else res.add(String.valueOf(i));
        }
        return res;
    }
}
