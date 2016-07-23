package leetcode;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/23.
 */
public class CountNumbersWithUniqueDigits {

    //用数学的组合知识
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;

        int result = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            result += uniqueDigits;
            availableNumber--;
        }
        return result;
    }

    public static void main(String[] args) {
        test(7);
    }

    private static void test(int i) {
        long before = new Date().getTime();
        System.out.println("input : " + i);
        System.out.println("output : " + new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(i));
        long after = new Date().getTime();
        System.out.println("--------   " + (after - before) + "   ------------------------------");
    }
}
