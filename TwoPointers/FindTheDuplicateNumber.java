package leetcode.TwoPointers;

/**
 * Created by freewheel on 2017/2/23.
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 5, 7, 6, 4};
        new FindTheDuplicateNumber().findDuplicated(nums);
    }

    public int findDuplicate(int[] nums) {
        int head = 0;
        int tail = 1;
        int currentNum = nums[0];
        int len = nums.length;

        while (true) {
            if (nums[tail] == currentNum) {
                return currentNum;
            } else {
                if (tail == len - 1) {
                    head++;
                    currentNum = nums[head];
                    tail = head + 1;
                } else {
                    tail++;
                }
            }
        }
    }

    //similar to the two pointers find cycle in linkedlist
    public int findDuplicated(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
