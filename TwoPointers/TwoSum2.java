package leetcode.TwoPointers;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/10.
 */
public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 18;

        System.out.println(Arrays.toString(new TwoSum2().twoSum(nums, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0, ptr2 = numbers.length - 1;
        int[] ret = new int[2];

        int diff;

        while (ptr1 < ptr2) {
            diff = target - numbers[ptr1];
            while (numbers[ptr2] > diff) {
                ptr2--;
            }
            if (numbers[ptr2] == diff) {
                ret[0] = ptr1+1;
                ret[1] = ptr2+1;
                return ret;
            } else {
                diff = target - numbers[ptr2];
                while (numbers[ptr1] < diff) {
                    ptr1++;
                }

                if (numbers[ptr1] == diff) {
                    ret[0] = ptr1+1;
                    ret[1] = ptr2+1;
                    return ret;
                }
            }
        }
        return ret;
    }
}
