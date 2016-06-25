package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/24.
 */
public class HouseRobber {

    public int rob1(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) return 0;
        if (length == 1) return nums[0];
        int[] maxValues = new int[length];
        maxValues[0] = nums[0];
        maxValues[1] = bigger(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            maxValues[i] = bigger(nums[i] + maxValues[i - 2], maxValues[i - 1]);
        }
        return maxValues[length - 1];
    }

    public int rob2(int[] nums) {

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                a += nums[i];
                a = bigger(a, b);
            } else {
                b += nums[i];
                b = bigger(a, b);
            }
        }
        return bigger(a, b);
    }

    public int rob(int[] nums) {

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            int m = a, n = b;
            a = n + nums[i];
            System.out.println("a " + a);
            b = bigger(m, n);
            System.out.println("b " + b);
        }

        System.out.println("result a " + a + " ;b " + b);
        return bigger(a, b);
    }


    private int bigger(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }


    public static void main(String[] args) {
        test(new int[]{});
        test(new int[]{5});
        test(new int[]{3, 5});
        test(new int[]{2, 5, 4});
        test(new int[]{2, 5, 6, 2});
        test(new int[]{4, 5, 1, 9, 6});
        test(new int[]{4, 5, 1, 5, 6});
        test(new int[]{4, 5, 2, 7, 8});
        test(new int[]{1, 3, 1, 3, 100});
        test(new int[]{4, 5, 2, 7, 8, 3});
//        test(new int[]{226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191, 68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209, 18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138, 212, 192, 125, 77, 223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123, 120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124});
    }

    private static void test(int[] nums) {
        HouseRobber robber = new HouseRobber();
        System.out.println(Arrays.toString(nums));
        System.out.println(robber.rob(nums));
        System.out.println("--------");
    }
}
