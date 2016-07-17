package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/17.
 */
public class SingleNumber {
    public int singleNumber1(int[] nums) {

        int length = nums.length;
        if (length == 1) return nums[0];

        int sum = 0;
        boolean addFlag = true;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (addFlag)
                sum += nums[i];
            else
                sum -= nums[i];
            addFlag = (!addFlag);
        }
        return sum;
    }

    public int singleNumber(int[] nums) {

        int length = nums.length;
        if (length == 1) return nums[0];

        int sum = 0;

        for (int i = 0; i < length; i++) {
            sum ^= nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        test(new int[]{3, 2, 4, 2, 3});
        test(new int[]{3, 2, 1, 2, 3});
        test(new int[]{1, 2, 3, 2, 3});
    }

    private static void test(int[] nums) {
        System.out.println("input " + Arrays.toString(nums));
        System.out.println("result " + new SingleNumber().singleNumber(nums));
        System.out.println("------------------------------");
    }
}
