package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Administrator on 2016/8/15.
 */
public class ShuffleAnArray {

    final int[] nums;
    Random rand = new Random();

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        rand.setSeed(System.nanoTime());
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
//    public int[] shuffle() {
//        int length = nums.length;
//        int[] result = nums.clone();
//        boolean[] records = new boolean[length];
//
//        int count = 0;
//        while (count < length) {
//            int randIndex = rand.nextInt(length);
//            while (records[randIndex]) {
//                randIndex = rand.nextInt(length);
//            }
//            records[randIndex] = true;
//            result[count++] = nums[randIndex];
//        }
//        return result;
//    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++) {
            int i = rand.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.reset()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.reset()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        HashMap<Character,Integer> map = new HashMap<>();
    }
}
