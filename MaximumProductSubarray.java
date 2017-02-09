package leetcode;

/**
 * Created by freewheel on 2017/2/9.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        if (nums.length == 1) return nums[0];

        // number of - , odd and even
        // consider 0

        int maxResult = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxResult = Math.max(maxProduct(nums, start, i - 1), maxResult);
                start = i + 1;
            }

        }

        if (nums[nums.length - 1] != 0)
            maxResult = Math.max(maxProduct(nums, start, nums.length - 1), maxResult);


        return maxResult;
    }

    public int maxProduct(int[] nums, int start, int end) {
        if (start > end || start < 0) return Integer.MIN_VALUE;

        if (start==end) return nums[start];

        int negativeCounter = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] < 0) negativeCounter++;
        }

        int maxResult = Integer.MIN_VALUE;
        if ((negativeCounter & 1) == 0) {
            maxResult = product(nums, start, end);
        } else {
            //find first negative number
            int tempResult1 = 0, tempResult2 = 0;
            for (int i = start; i <= end; i++) {
                if (nums[i] < 0) {
                    tempResult1 = product(nums, i + 1, end);
                    break;
                }
            }

            //find the last negative number
            for (int i = end; i >= start; i--) {
                if (nums[i] < 0) {
                    tempResult2 = product(nums, start, i - 1);
                    break;
                }
            }

            maxResult = Math.max(tempResult1, tempResult2);
        }

        return maxResult;
    }


    public int product(int[] nums, int start, int end) {
        if (start < 0 || end > nums.length || start > end) return 0;
        int result = 1;
        for (int i = start; i <= end; i++) {
            result *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumProductSubarray a = new MaximumProductSubarray();
        int[] nums = {0, 2};
        System.out.println(a.maxProduct(nums));


    }

// Another method, simple but not efficient as the above
//    public int maxProduct(int[] A) {
//        if (A.length == 0) {
//            return 0;
//        }
//
//        int maxherepre = A[0];
//        int minherepre = A[0];
//        int maxsofar = A[0];
//        int maxhere, minhere;
//
//        for (int i = 1; i < A.length; i++) {
//            maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
//            minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
//            maxsofar = Math.max(maxhere, maxsofar);
//            maxherepre = maxhere;
//            minherepre = minhere;
//        }
//        return maxsofar;
//    }
}
