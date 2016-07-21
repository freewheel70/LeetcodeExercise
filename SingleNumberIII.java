package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/7/17.
 */
public class SingleNumberIII {
    public int[] singleNumber1(int[] nums) {

        int length = nums.length;
        if (length == 2) return nums;

        int sum = 0;
        int counter = 0;
        Arrays.sort(nums);
//        System.out.println("after sort " + Arrays.toString(nums));
        int[] result = new int[2];
        if ((nums[0] ^ nums[1]) != 0) {//first element is target
            result[0] = nums[0];
            if ((nums[1] ^ nums[2]) != 0) {//second element is also target
                result[1] = nums[1];
                return result;
            } else {
                for (int i = 3; i < length; i++) {
                    sum ^= nums[i];
                    counter++;
                    if (counter == 2) {
                        if (sum != 0) {
                            result[1] = nums[i - 1];
                            return result;
                        }
                        counter = 0;
                    }
                }
                result[1] = nums[length - 1];
                return result;
            }
        } else {//first and second element is not target

            int firstIndex = 0;
            for (int i = 2; i < length; i++) {
                sum ^= nums[i];
                counter++;
                if (counter == 2) {
                    if (sum != 0) {
                        firstIndex = i - 1;
                        break;
                    }
                    counter = 0;
                }
            }
            result[0] = nums[firstIndex];

            counter = 0;
            sum = 0;
            for (int i = firstIndex + 1; i < length; i++) {
                sum ^= nums[i];
                counter++;
                if (counter == 2) {
                    if (sum != 0) {
                        result[1] = nums[i - 1];
                        return result;
                    }
                    counter = 0;
                }
            }
            result[1] = nums[length - 1];
            return result;
        }

    }

    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 5, 3, 2, 5});
        test(new int[]{-1638685546, -2084083624, -307525016, -930251592, -1638685546, 1354460680, 623522045, -1370026032, -307525016, -2084083624, -930251592, 472570145, -1370026032, 1063150409, 160988123, 1122167217, 1145305475, 472570145, 623522045, 1122167217, 1354460680, 1145305475});
    }

    private static void test(int[] nums) {
        System.out.println("input " + Arrays.toString(nums));
        System.out.println("result " + Arrays.toString(new SingleNumberIII().singleNumber(nums)));
        System.out.println("------------------------------");
    }
}
