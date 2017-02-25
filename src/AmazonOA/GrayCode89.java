package AmazonOA;

import java.util.ArrayList;
import java.util.List;

//medium
public class GrayCode89 {
    public List<Integer> grayCode(int n) {
        //dp, symmetric the previous, one half add 0, another add 1
        //in bit manipulation, equals to adding 2^(n-1);
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int m = 1; m <= n; m++) {
            for(int i = res.size() - 1; i >= 0; i--) {
                res.add(res.get(i) + (1 << (m - 1)));//bit manipulation has a low priority, so add ()
            }
        }
        return res;
     }
}
