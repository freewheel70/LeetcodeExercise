package leetcode.Math;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/16.
 */
public class MinimumMovestoEqualArrayElements2 {

    //Always choose the middle value will lead to min move
    public int minMoves2(int[] nums) {
        if (nums.length == 1) return 0;


        Arrays.sort(nums);

        int result = 0;

        int mid = nums.length >> 1;

        //even or odd length share the same code amazingly
        for (int i = 0; i < mid; i++) {
            result += (nums[nums.length - 1 - i] - nums[i]);
        }

        return result;
    }
}
