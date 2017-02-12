package leetcode.Math;

/**
 * Created by freewheel on 2017/2/11.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int nums[] = {2, 0};
        System.out.println(new MissingNumber().missingNumber(nums));
    }

    //method I
    //using negative value to mark
    public int missingNumber1(int[] nums) {

        int max = -1;

        int zeroPos = -1;

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (val == nums.length) {
                max = val;
            } else {
                nums[val] = -Math.abs(nums[val]);
                if (val == 0) {
                    zeroPos = i;
                }
            }

        }

        if (max == -1) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        return zeroPos;
    }

    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
