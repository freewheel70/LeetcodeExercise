package leetcode.Stack;

import java.util.*;

/**
 * Created by freewheel on 2017/2/9.
 */
public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(new NextGreaterElement1().nextGreaterElement2(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();

        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < findNums.length; i++) {
            int target = findNums[i];
            fillStack(stack, nums);
            while (stack.size() != 0) {
                if (target == stack.pop()) {
                    boolean found = false;
                    while (stack.size() != 0) {
                        int greaterNum = stack.pop();
                        if (greaterNum > target) {
                            results.add(greaterNum);
                            found = true;
                            stack.clear(); // stack is empty
                        }
                    }
                    //stack is empty
                    if (!found) {
                        results.add(-1);
                    }
                }
            }

        }

        int[] resultArr = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultArr[i] = results.get(i);
        }
        return resultArr;

    }

    private void fillStack(LinkedList<Integer> stack, int[] nums) {
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(nums[i]);
        }
    }


    public int[] nextGreaterElement2(int[] findNums, int[] nums) {

        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < findNums.length; i++) {
            int target = findNums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == target) {
                    boolean found = false;
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] > target) {
                            results.add(nums[k]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        results.add(-1);
                    }
                }
            }
        }

        int[] resultArr = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultArr[i] = results.get(i);
        }
        return resultArr;
    }

    public int[] nextGreaterElement3(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            //先入栈的是数组的左侧数字，如果这些数字中有的比当前数字（相对而言的右侧数字）更小
            //那么当前数字就是左侧数字的greater number
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }


        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);

        return findNums;
    }
}
