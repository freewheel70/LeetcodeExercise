package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/26.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean addNewPos = false;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                if (i == 0) addNewPos = true;
            } else {
                digits[i]++;
                break;
            }
        }

        if (addNewPos) {
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < length + 1; i++) {
                newDigits[i] = digits[i - 1];
            }

            return newDigits;
        }

        return digits;
    }

    public static void main(String[] args) {
        test(new int[]{1});
        test(new int[]{9});
        test(new int[]{2, 2});
        test(new int[]{3, 9});
        test(new int[]{9, 9, 9});
    }

    private static void test(int[] digits) {
        PlusOne plus = new PlusOne();
        System.out.println("input " + Arrays.toString(digits));
        System.out.println("result " + Arrays.toString(plus.plusOne(digits)));
        System.out.println("--------");
    }
}
