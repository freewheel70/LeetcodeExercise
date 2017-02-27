package leetcode.BackTracking;

import java.util.Arrays;

/**
 * Created by freewheel on 2017/2/21.
 */
public class BeautifulArrangement {

//    int[] nums;
//    int target;
//    int counter = 0;
//
//
//    public int countArrangement1(int N) {
//        if (N < 3) return N;
//
//        nums = new int[N + 1];
//        Arrays.fill(nums, -1);
//
//        target = N;
//
//        check1(1);
//
//        return counter;
//    }
//
//    private void check1(int n) {
//        if (n > target) {
//            counter++;
//            return;
//        }
//
//        for (int j = 1; j < target + 1; j++) {
//
//            if (nums[j] != -1) continue;//had been used
//
//            if (n % j == 0 || j % n == 0) {
//                nums[j] = n;
//
//                check1(n + 1);
//
//                nums[j] = -1;
//            }
//        }
//    }


    //put method one 's global variable into parameters
    //become much faster
    int counter = 0;

    public int countArrangement(int N) {
        if (N < 3) return N;

        int[] nums = new int[N + 1];
        Arrays.fill(nums, -1);

        check(1, N, nums);

        return counter;
    }

    private void check(int n, int target, int[] nums) {
        if (n > target) {
            counter++;
            return;
        }

        for (int j = 1; j < target + 1; j++) {

            if (nums[j] != -1) continue;//had been used

            if (n % j == 0 || j % n == 0) {
                nums[j] = n;

                check(n + 1, target, nums);

                nums[j] = -1;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(3));
    }

}
