package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/30.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) return length;

        int last = length - 1;
        for (int i = 1; i < length; i++) {

            while (nums[i] == nums[i - 1]) {
                if (i == last) return last;
                moveBackward(nums, i, last);
                last--;
            }
            if (i == last) return last + 1;
        }
//        System.out.println("last");
        return last + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    private void moveBackward(int[] nums, int index, int last) {
        for (int i = index; i < last; i++) {
            nums[i] = nums[i + 1];
        }
    }

    public static void main(String[] args) {
        test(new int[]{1, 1, 1, 2});
        test(new int[]{1, 2, 3});
        test(new int[]{1, 1, 2, 2, 3, 3, 3, 3});
    }

    private static void test(int[] nums) {
        RemoveDuplicatesfromSortedArray removeDup = new RemoveDuplicatesfromSortedArray();
        System.out.println("input " + Arrays.toString(nums));
        System.out.println("result " + removeDup.removeDuplicates(nums) + " " + Arrays.toString(nums));
        System.out.println("------");
    }
}
