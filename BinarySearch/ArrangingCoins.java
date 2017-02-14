package leetcode.BinarySearch;

/**
 * Created by freewheel on 2017/2/14.
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(7));
        System.out.println(new ArrangingCoins().arrangeCoins(1804289383));
    }

    public int arrangeCoins(int n) {

        long number = n;
        while (getSum(number) > n) {
            number = (number + n * 2 / (number + 1)) >> 1;
        }

        while (getSum(number) < n) {
            number++;
        }

        if (getSum(number) == n)
            return (int) number;
        else
            return (int) number - 1;
    }

    private long getSum(long num) {
        return (num + 1) * num / 2;
    }
}
