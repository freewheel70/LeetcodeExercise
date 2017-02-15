package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/9.
 */
public class BestTimetoBuyandSellStock2 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 2, 3, 6, 4};
        System.out.println(new BestTimetoBuyandSellStock2().maxProfit(prices));
    }

    //dp
    //dp(i) = dp(i-1) + p(i) - p(buy)
//    public int maxProfit(int[] prices) {
//
//        if (prices.length < 2) return 0;
//
//        int profit = 0;
//        int buyPos = 0;
//        int sellPos = 0;
//        int roundProfit = 0;
//        boolean roundStart = true;
//
//        for (int i = 0; i < prices.length; i++) {
//            //case start buy
//            if (roundStart) {
//                //start buying, choose the cheapest price
//                while (prices[i] < prices[buyPos]) {
//                    buyPos = i;
//                    i++;
//                }
//                sellPos = i;
//                roundProfit = prices[sellPos] - prices[buyPos];
//                roundStart = false;
//
//            } else {// buy started
//                if (prices[i] < prices[buyPos]) {
//                    buyPos = i;
//                    sellPos = i;
//                } else {
//                    if (prices[i] > prices[buyPos]) {
//                        if (prices[i] > prices[sellPos]) {
//                            sellPos = i;
//                            roundProfit = prices[sellPos] - prices[buyPos];
//                        } else if (prices[i] < prices[sellPos]) {
//                            //case round end
//                            buyPos = i;
//                            sellPos = i;
//                            profit += roundProfit;
//                            roundStart = true;
//                        } else {
//                            //same as last sell price, do nothing
//                        }
//                    } else {
//                        //same as buy price
//                    }
//                }
//            }
//
//        }
//
//        return profit;
//    }

    //dp(i) = dp(i-1) + p(i) - p(buy)
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int profits[] = new int[prices.length];
        profits[0] = 0;
        int lastBuyPrice;
        for (int i = 1; i < prices.length; i++) {
            //case current > last
            if (prices[i] > prices[i - 1]) {
                profits[i] = profits[i - 1] + (prices[i] - prices[i - 1]);
            } else {
                profits[i] = profits[i - 1];
            }
        }

        // 1 23456 5 7
        return profits[prices.length - 1];
    }
}
