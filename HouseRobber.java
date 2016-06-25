package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/24.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0) return 0;
        if (length == 1) return nums[0];

        int result = 0;
        int index = 0;

        while (true) {
            if (index + 4 == length - 1) {
                if (nums[index] > nums[index + 1]) {
                    result += nums[index];
                    index += 2;
                } else {
                    int solu1 = nums[index] + nums[index + 2] + nums[index + 4];
                    int solu2 = nums[index + 1] + nums[index + 3];
                    int solu3 = nums[index + 1] + nums[index + 4];
                    int max = solu1;
                    if (solu2 > max) {
                        max = solu2;
                    }
                    if (solu3 > max) {
                        max = solu3;
                    }
                    result += max;
                    break;
                }
            } else if (index + 3 == length - 1) {
                if (nums[index] > nums[index + 1]) {
                    if (nums[index + 2] > nums[index + 3]) {
                        result += (nums[index] + nums[index + 2]);
                    } else {
                        result += (nums[index] + nums[index + 3]);
                    }
                } else if (nums[index] + nums[index + 2] > nums[index + 1] + nums[index + 3]) {
                    result += (nums[index] + nums[index + 2]);
                } else {
                    result += (nums[index + 1] + nums[index + 3]);
                }
                break;
            } else if (index + 2 == length - 1) {
                if (nums[index] + nums[index + 2] > nums[index + 1]) {
                    result += (nums[index] + nums[index + 2]);
                } else {
                    result += nums[index + 1];
                }
                break;
            } else if (index + 1 == length - 1) {
                if (nums[index] > nums[index + 1]) {
                    result += nums[index];
                } else {
                    result += nums[index + 1];
                }
                break;
            } else {
                if (nums[index] > nums[index + 1]) {
                    result += nums[index];
                    index += 2;
                } else {
                    result += nums[index + 1];
                    index += 3;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        test(new int[]{5});
        test(new int[]{3, 5});
        test(new int[]{2, 5, 4});
        test(new int[]{2, 5, 6, 2});
        test(new int[]{4, 5, 1, 9, 6});
        test(new int[]{4, 5, 1, 5, 6});
        test(new int[]{4, 5, 2, 7, 8});
        test(new int[]{1, 3, 1, 3, 100});
        test(new int[]{4, 5, 2, 7, 8, 3});
    }

    private static void test(int[] nums) {
        HouseRobber robber = new HouseRobber();
        System.out.println(Arrays.toString(nums));
        System.out.println(robber.rob(nums));
        System.out.println("--------");
    }
}
