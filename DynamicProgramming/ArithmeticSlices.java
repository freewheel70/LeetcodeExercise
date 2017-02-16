package leetcode.DynamicProgramming;

/**
 * Created by freewheel on 2017/2/16.
 */
public class ArithmeticSlices {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(nums));
    }

    //convert the problem into the problem that find the consecutive same numbers
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int[] diffs = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            diffs[i] = nums[i + 1] - nums[i];
        }

        //1 1 2 2 2 3

        int counter = 0;
        int[] dp = new int[nums.length - 1];
        dp[0] = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (diffs[i] == diffs[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
                counter += calcCombinations(dp[i - 1]);
            }

        }

        counter += calcCombinations(dp[nums.length - 2]);

        return counter;

        //find the consecutive and same diffs

        // 111   1
        // 1111  2 + 1
        // 11111 3+ 2+1

    }

    private int calcCombinations(int num) {
        return num * (num - 1) / 2;
    }


    //the diff array could be removed to save space
    //but may calc diff repeatedly
    public int numberOfArithmeticSlices2(int[] nums) {
        if (nums.length < 3) return 0;

        int counter = 0;
        int[] dp = new int[nums.length - 1];
        dp[0] = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] == nums[i] - nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
                counter += calcCombinations(dp[i - 1]);
            }
        }

        counter += calcCombinations(dp[nums.length - 2]);

        return counter;
    }
}
