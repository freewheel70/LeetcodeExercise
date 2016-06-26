package leetcode;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/6/26.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return (nums[0] == val) ? 0 : 1;

        int indexHead = 0;
        int indexTail = length - 1;
        int valNum = 0;

        while (indexHead != indexTail) {
            System.out.println(Arrays.toString(nums));
            while (nums[indexHead] != val) {
                indexHead++;
                if (indexHead == indexTail) break;
            }

            if (indexHead == indexTail) {
                if (nums[indexTail] == val) valNum++;
                break;
            }

            while (nums[indexTail] == val) {
                valNum++;
                indexTail--;
                if (indexHead == indexTail) {
                    if (nums[indexTail] == val) valNum++;
                    break;
                }
            }
            if (indexHead == indexTail) break;

            int temp = nums[indexHead];
            nums[indexHead] = nums[indexTail];
            nums[indexTail] = temp;
        }

        return length - valNum;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public int removeElement3(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] elements = {3,3,2,3};
        System.out.println(removeElement.removeElement2(elements, 3));
    }

}
