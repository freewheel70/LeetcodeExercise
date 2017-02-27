package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by freewheel on 2017/2/26.
 */
public class FractionsProcessing {

    public static void main(String[] args) {
        test(new int[][]{{1, 2}, {3, 4}, {5, 25}});
        test(new int[][]{{1, 2}, {2, 4}, {6, 9}});
        test(new int[][]{{1, 2}, {14, 24}, {6, 20}});

    }

    private static void test(int[][] nums) {
        FractionsProcessing fp = new FractionsProcessing();

        for (int[] anInt : nums) {
            System.out.println(Arrays.toString(anInt));
        }

        int[][] ints = fp.processFractions(nums);

        System.out.println("result: ");

        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

        System.out.println();
    }

    public int[][] processFractions(int[][] fractions) {
        for (int[] fraction : fractions) {
            process(fraction);
        }

        Arrays.sort(fractions, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                int val1 = i1[0] * i2[1];
                int val2 = i2[0] * i1[1];

                return val1 == val2 ? 0 : (val1 > val2 ? 1 : -1);
            }
        });

        return fractions;
    }

    private void process(int[] fraction) {

        while (true) {
            boolean dividable = false;
            for (int i = 2; i <= fraction[0]; i++) {
                if (fraction[0] % i == 0 && fraction[1] % i == 0) {
                    fraction[0] = fraction[0] / i;
                    fraction[1] = fraction[1] / i;
                    dividable = true;
                    break;
                }
            }

            if (!dividable) {
                break;
            }
        }
    }
}
