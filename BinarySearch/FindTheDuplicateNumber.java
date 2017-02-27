package leetcode.BinarySearch;

/**
 * Created by freewheel on 2017/2/23.
 * n + 1 integers where each integer is between 1 and n (inclusive)
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int low = 1;
        int high = len - 1;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count += 1;
            }

            if (count <= mid)
                low = mid + 1;
            else
                high = mid;
        }

        return low;

    }
}
