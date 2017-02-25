package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(prices[0]);
        for(int p : prices) {
            List<Integer> temp = new ArrayList<Integer>(list);
            for(int ele : temp) {
                if (p > ele) {
                    int profit = p - ele;
                    if (profit > res) {
                        res = profit;
                        
                        break;
                    }
                }
            }
            if (p < temp.get(temp.size()-1)) {
                list.add(p);
            }
            list.sort((e1, e2) -> e1.compareTo(e2));//same
//            Collections.sort(list);
            System.out.println(list);
            
        }
        System.out.println(list);
        System.out.println(res);
        return res;
        
    }
    public static void main(String[] args) {
        BestTimetoBuyandSellStock121 x = new BestTimetoBuyandSellStock121();
        x.maxProfit(new int[]{7,1,5,3,6,4});
    }

}
