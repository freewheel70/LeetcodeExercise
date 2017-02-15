package leetcode;

/**
 * Created by freewheel on 2017/2/15.
 */
public class ThirdMaximumNumber {

    public static void main(String[] args) {


    }

    public int thirdMax(int[] nums) {
        if (nums.length < 3) {
            if (nums.length == 1) return nums[0];
            else return Math.max(nums[0], nums[1]);
        } else {
            return findThirdMax(nums);
        }
    }

    private int findThirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean minFlag = false;

        for (int num : nums) {
            if (num > first) first = num;
        }

        for (int num : nums) {
            if (num > second && num != first) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            return first;
        }

        for (int num : nums) {
            if (num >= third && num != first && num != second) {
                third = num;
                minFlag = (num == Integer.MIN_VALUE);
                //if minFlag is true, it indicates Integer.MIN_VALUE is in the array
            }
        }

        //if third == Integer.MIN_VALUE and minFlag is true, that means Integer.MIN_VALUE is in the array
        //and it manage to stay in third max position
        //on the other hand, if third == Integer.MIN_VALUE but minFlag is false, that means Integer.MIN_VALUE
        // is not in the array, and third keeps its initial values which means only less than 3 kinds of number
        // in array
        if (third == Integer.MIN_VALUE && !minFlag)
            return first;

        return third;
    }

}
