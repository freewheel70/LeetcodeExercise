package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/24.
 * he old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have taken
 * those words to heart.
 * Every resident hates his next-door neighbors on both sides. Nobody is willing to live farther
 * away from the town's well than his neighbors, so the town has been arranged in a big circle around
 * the well. Unfortunately, the town's well is in disrepair and needs to be restored. You have been
 * hired to collect donations for the Save Our Well fund.
 * <p>
 * Each of the town's residents is willing to donate a certain amount, as specified in the int[] donations,
 * which is listed in clockwise order around the well. However, nobody is willing to contribute to a fund
 * to which his neighbor has also contributed.
 * Next-door neighbors are always listed consecutively in donations, except that the first and last entries
 * in donations are also for next-door neighbors. You must calculate and return the maximum amount of
 * donations that can be collected.
 * <p>
 * <p>
 * Definition
 * <p>
 * Class:	HouseRobberII
 * Method:	maxDonations
 * Parameters:	int[]
 * Returns:	int
 * Method signature:	int maxDonations(int[] donations)
 * (be sure your method is public)
 * <p>
 * <p>
 * Constraints
 * -	donations contains between 2 and 40 elements, inclusive.
 * -	Each element in donations is between 1 and 1000, inclusive.
 * <p>
 * Examples
 * 0)
 * <p>
 * { 10, 3, 2, 5, 7, 8 }
 * Returns: 19
 * The maximum donation is 19, achieved by 10+2+7. It would be better to take 10+5+8 except that the 10 and 8 donations are from neighbors.
 * 1)
 */
public class HouseRobberII {
    public int rob(int[] moneys) {
        int length = moneys.length;

        if (length == 1) return moneys[0];
        if (length == 2) return Math.max(moneys[0], moneys[1]);

        int donationsWithoutTail = calc(moneys, 0, length - 2);
        int donationsWithoutHead = calc(moneys, 1, length - 1);

        return Math.max(donationsWithoutHead, donationsWithoutTail);
    }

    private int calc(int[] moneys, int start, int end) {
        if (start > end) return 0;
        if (start == end) return moneys[start];
        if (start + 1 == end) return Math.max(moneys[start], moneys[end]);

        int[] records = new int[end - start + 1];
        records[0] = moneys[start];
        records[1] = Math.max(moneys[start], moneys[start + 1]);

        for (int i = 2; i <= end - start; i++) {
            records[i] = Math.max(records[i - 1], moneys[start + i] + records[i - 2]);
        }

        return records[end - start];
    }
}
