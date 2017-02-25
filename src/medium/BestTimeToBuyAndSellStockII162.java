package medium;

public class BestTimeToBuyAndSellStockII162 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int low = 0;
        int high = 0;
        int profit = 0;
        int pointer = 0;
        while (pointer < prices.length) {
            // System.out.println(pointer + " " + low);
            while (pointer < prices.length && prices[pointer] <= prices[low]) {
                low = pointer;
                pointer++;
            }
            high = pointer;
            pointer++;
            while (pointer < prices.length && prices[pointer] >= prices[high]) {
                high = pointer;
                pointer++;
            }
            if (high >= prices.length) break;
            profit += prices[high] - prices[low];
            low = pointer;
            // System.out.println("~~~ " + pointer);
        } 
        return profit;
    }
}
