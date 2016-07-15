package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/14.
 */
public class RotateArray {
    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        if (k == length) return;
        if (k > length) {
            k = k % length;
            if (k == length) return;
        }
        int[] copy = new int[length];
        System.arraycopy(nums, 0, copy, 0, length);
        for (int i = 0; i < length - k; i++) {
            nums[i + k] = copy[i];
        }
        for (int i = length - k; i < length; i++) {
            nums[i - length + k] = copy[i];
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k == length) return;
        if (k > length) {
            k = k % length;
            if (k == length) return;
        }
        int[] head = new int[length - k];
        int[] tail = new int[k];
        System.arraycopy(nums, 0, head, 0, length - k);
//        System.out.println(Arrays.toString(head));
        System.arraycopy(nums, length - k, tail, 0, k);
//        System.out.println(Arrays.toString(tail));

        for (int i = 0; i < k; i++) {
            nums[i] = tail[i];
        }

        for (int i = 0; i < length - k; i++) {
            nums[k+i] = head[i];
        }
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
    }

    private static void test(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        System.out.println("rotate " + k);
        new RotateArray().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
        System.out.println("----------------------------------");
    }
}
