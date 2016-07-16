package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/16.
 */
public class CountingBits {
    /**
     * 0 1 10 11   100 101 110 111    1000 1001 1010 1011  1100  1101  1110 1111
     * 0 1 1  2    1   2   2   3       1    2    2    3      2    3     3     4
     */

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num <= 1) {
            for (int i = 0; i < num + 1; i++) {
                result[i] = i;
            }
            return result;
        } else {
            for (int i = 0; i < 2; i++) {
                result[i] = i;
            }
            int interval = 2;
            int lastEnd = 2;
            int end = 4;

            while (true) {
                for (int i = lastEnd; i < end; i++) {
                    if (i == num + 1) return result;
                    result[i] = result[i - interval] + 1;
                }
                interval = end;
                lastEnd = end;
                end = end * 2;
            }

        }
    }

    public static void main(String[] args) {
        test(1);
        test(2);
        test(3);
        test(5);
    }

    private static void test(int i) {
        System.out.println("number " + i);
        System.out.println(Arrays.toString(new CountingBits().countBits(i)));
        System.out.println("------------------------------");
    }
}
