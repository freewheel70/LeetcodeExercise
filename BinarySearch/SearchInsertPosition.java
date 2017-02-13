package leetcode.BinarySearch;

/**
 * Created by freewheel on 2017/2/13.
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 2;

        System.out.println(new SearchInsertPosition().searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start >= end) {
            int pos = start > nums.length - 1 ? end : start;

            if (nums[pos] == target) {
                return start;
            } else {
                if (nums[pos] > target) {
                    return start;
                } else {
                    return start + 1;
                }
            }
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else {
            if (nums[mid] > target) {
                return search(nums, start, mid - 1, target);
            } else {
                return search(nums, mid + 1, end, target);
            }
        }
    }

    //non-recursion method
    public int searchInsert2(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
