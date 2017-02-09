package leetcode;

/**
 * Created by freewheel on 2017/2/8.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {8, -19, 5, -4, 20};
        System.out.println(maxSubArray(nums));
    }

    //Subarray
    //create an array of pre sum
    //
    public static int maxSubArray(int[] nums) {
//        if (nums.length < 1) return 0;
//        if (nums.length == 1) return nums[0];
//        int[] sums = new int[nums.length + 1];
//        sums[0] = 0;
//        for (int i = 1; i < sums.length; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//
//        //find the two pos, diff max
//        //  2min  1max 1min  2max
//        int min = sums[0];
//        int minPos = 0;
//        int max = sums[1];
//        int maxPos = 1;
//        int diff = max - min;
//        int minerPos = 0;
//        for (int i = 1; i < sums.length; i++) {
//            //find miner
//            //find maxer
//            //find larger diff
//            if (sums[i] > max) {
//                max = sums[i];
//                maxPos = i;
//                min = sums[minerPos];
//                minPos = minerPos;
//                diff = max - min;
//            } else {
//                if (sums[i] - sums[minerPos] > diff) {
//                    diff = sums[i] - sums[minerPos];
//                }
//
//                if (sums[i] < sums[minerPos]) {
//                    minerPos = i;
//                }
//            }
//        }
//
//        return diff;

//        method 2
//        int newsum=nums[0];
//        int max=nums[0];
//        for(int i=1;i<nums.length;i++){
//            newsum=Math.max(newsum+nums[i],nums[i]);
//            max= Math.max(max, newsum);
//        }
//        return max;

//        method 3 - dp
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;

    }

}
