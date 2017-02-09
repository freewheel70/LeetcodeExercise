package leetcode.Stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by freewheel on 2017/2/9.
 */
public class NextGreaterElement2 {
    public static void main(String[] args) {

        int[] nums = {1, 8, -1, -100, -1, 222, 1111111, -111111};

        System.out.println(Arrays.toString(new NextGreaterElement2().nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        LinkedList<Tuple> stack = new LinkedList<>();
        int[] results = new int[nums.length];

        Arrays.fill(results,-1);
        boolean[] marks = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (!stack.isEmpty() && stack.peek().value < num) {
                int pos = stack.pop().pos;
                results[pos] = num;
                marks[pos] = true;
            }

            stack.push(new Tuple(i, num));
        }

        for (int i = 0; i < results.length; i++) {
            if (!marks[i]) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        results[i] = nums[j];
                        break;
                    }
                }
            }
        }

        return results;
    }

    static class Tuple {
        int pos;
        int value;

        Tuple(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }
    }
}
