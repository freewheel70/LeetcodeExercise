package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by freewheel on 2017/2/16.
 */
public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0) {
                result.add(val);
            } else {
                nums[val - 1] *= -1;
            }
        }

        return result;
    }

}
