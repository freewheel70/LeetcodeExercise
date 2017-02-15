package leetcode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by freewheel on 2017/2/9.
 */
public class BestTimetoBuyandSellStock3 {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for (int price : prices) {                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2 + price);     // The maximum if we've just sold 2nd stock so far.
            hold2 = Math.max(hold2, release1 - price);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1 + price);     // The maximum if we've just sold 1nd stock so far.
            hold1 = Math.max(hold1, -price);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}
