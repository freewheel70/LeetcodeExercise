package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/10.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> remainders = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (remainders.containsKey(num)) {
                return new int[]{remainders.get(num), i};
            } else {
                int remainder = target - num;
                remainders.put(remainder, i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 2, 4}, 6)));
    }
}
